#include<stdio.h>
#include<math.h>

#define _USE_MATH_DEFINES
#define N 320
#define PI 3.1415

FILE *fin;
FILE *forigin_spec;
FILE *flow_time_env;
FILE *fhigh_time_env;
FILE *flog_spec_env;
FILE *flow_lifter;

void n_dft(double* signal, double* spec_mag, int N_PT);
void read_data(FILE *fp, double* signal, int N_PT, short *data);
void hamming_window(double *signal, double* window_signal, int N_PT);
void copy_spec(double* spec_mag, double* log_spec_mag, int N_PT);
void log_spec(double* log_spec_mag, int N_PT);
void inv_n_dft(double* spec_mag, double* signal, int N_PT);
void lowtime_liftering(double* log_spec_mag, double* low_lifter_cc, int N_PT, int lifter_point);
void hightime_liftering(double* log_spec_mag, double* high_lifter_cc, int N_PT, int lifter_point);
void get_envlp_file(FILE *fp, double* spec_env, int N_PT);
void get_log_env(FILE *fp, double* spec_mag, int N_PT);

int main(void) {

	//double  spec_real[N], spec_imag[N], freq;
	double signal[N], spec_mag[N], window_signal[N], log_spec_mag[N];
	double cepstrum[N], low_lifter_cc[N], high_lifter_cc[N], low_log_mag_spec_env[N], high_log_mag_spec_env[N];
	short data;
	int count = 0;

	// FILE CONNECT & EXCEPTION HANDLE //
	fopen_s(&fin, "Male.raw", "rb");
	fopen_s(&flow_time_env, "low_time_env.txt", "wb");
	fopen_s(&fhigh_time_env, "high_time_env.txt", "wb");
	fopen_s(&forigin_spec, "origin_spec.txt", "wb");
	fopen_s(&flog_spec_env, "log_spec.txt", "wb");
	fopen_s(&flow_lifter, "low_lifter.txt", "wb");

	if (fin == NULL || flow_time_env == NULL || fhigh_time_env == NULL || forigin_spec == NULL || flog_spec_env == NULL) {
		printf("NULL POINT EXCEPTION - ½ÇÆÐ\n");
		return 1;
	}

	// FILE READ
	read_data(fin, signal, N, &data);

	// Hamming Window
	hamming_window(signal, window_signal, N);

	// N-POINT DFT
	n_dft(window_signal, spec_mag, N);

	// Copy spec
	copy_spec(spec_mag, log_spec_mag, N);

	// Log spec (log|X[k]| + log|H[k]|, log(|X[k]|): High Time, log(|H[k]|): Low Time)
	log_spec(log_spec_mag, N);

	// Inverse-N-POINT DFT : Cepstrum
	inv_n_dft(log_spec_mag, cepstrum, N);

	// Low-time Liftering : Cepstrum Coefficient
	lowtime_liftering(cepstrum, low_lifter_cc, N, 15);

	// High-time Liftering : Cepstrum Coefficient
	hightime_liftering(cepstrum, high_lifter_cc, N, 15);

	// Low-time N-POINT DFT
	n_dft(low_lifter_cc, low_log_mag_spec_env, N);

	// High-time N-POINT DFT
	n_dft(high_lifter_cc, high_log_mag_spec_env, N);

	// Get envelope file
	get_envlp_file(flow_time_env, low_log_mag_spec_env, N);
	get_envlp_file(fhigh_time_env, high_log_mag_spec_env, N);
	get_envlp_file(forigin_spec, spec_mag, N);
	get_log_env(flog_spec_env, spec_mag, N);
	get_envlp_file(flow_lifter, low_lifter_cc, N);

	// File close
	fclose(fin);
	fclose(flow_time_env);
	fclose(fhigh_time_env);
	fclose(forigin_spec);
	fclose(flog_spec_env);
	fclose(flow_lifter);
}

void frame_number_count(FILE *fp) {
	if (fp == NULL) printf("Error!!\n");

	short fr_data;
	int count = 0;
	while (feof(fp) == 0) {
		fread(&fr_data, 2, 1, fin);
		count++;
	}
	printf("%d\n", count); //-> RESULT: 640 samples -> 0.8s
}

void read_data(FILE *fp, double* signal, int N_PT, short *data) {
	for (int i = 0; i < N_PT; i++) {
		fread(data, 2, 1, fin);
		signal[i] = (float)*data; // input array
	}
}

void hamming_window(double *signal, double* window_signal, int N_PT) {
	for (int n = 0; n < N_PT; n++) {
		window_signal[n] = signal[n] * (0.5 - 0.5*cos(2 * PI * n / (float)(N - 1)));
	}
	//TEST: for (int n = 0; n < N_PT; n++) printf("window_signal[%d] = %f\n", n, window_signal[n]);
}

void n_dft(double* signal, double* spec_mag, int N_PT) {
	double spec_real[N] = { 0.0, };
	double spec_imag[N] = { 0.0, };

	for (int k = 0; k < N_PT; k++) {
		spec_real[k] = spec_imag[k] = 0.0;
		for (int n = 0; n < N_PT; n++) {
			spec_real[k] = spec_real[k] + signal[n] * cos(2 * PI * k * n / (float)N); // DFT Real
			spec_imag[k] = spec_imag[k] - signal[n] * sin(2 * PI * k * n / (float)N); // DFT Imainary
		}

		spec_mag[k] = sqrt(pow(spec_real[k], 2) + pow(spec_imag[k], 2));      // |spec_mag[k]|^2 = |spec_real[k]|^2 + |spec_imag[k]|^2

		// TEST: printf("spec_mag[%d] = %f\n", k, spec_mag[k]);
	}
}

void copy_spec(double* spec_mag, double* log_spec_mag, int N_PT) {
	for (int i = 0; i < N_PT; i++) log_spec_mag[i] = spec_mag[i];
	//TEST: for (int n = 0; n < N_PT; n++) printf("log_spec_mag[%d] = %f\n", n, log_spec_mag[n]);
}

void log_spec(double* log_spec_mag, int N_PT) {
	double origin_log_spec[N];
	for (int i = 0; i < N_PT; i++) origin_log_spec[i] = log_spec_mag[i];
	for (int i = 0; i < N_PT; i++) log_spec_mag[i] = log10(origin_log_spec[i]);
	//TEST: for (int n = 0; n < N_PT; n++) printf("origin[%d] = %f || log_spec_mag[%d] = %f\n",n,origin_log_spec[n], n, log_spec_mag[n]);
}

void inv_n_dft(double* spec_mag, double* signal, int N_PT) {
	double sig_real[N] = { 0.0, };
	double sig_imag[N] = { 0.0, };

	for (int n = 0; n < N_PT; n++) {
		sig_real[n] = sig_imag[n] = 0.0;

		for (int k = 0; k < N_PT; k++) {
			sig_real[n] = sig_real[n] + spec_mag[k] * cos(2 * PI * k * n / (float)N_PT); // IDFT Real
			sig_imag[n] = sig_imag[n] + spec_mag[k] * sin(2 * PI * k * n / (float)N_PT); // IDFT Imainary
		}

		signal[n] = sqrt(pow(sig_real[n], 2) + pow(sig_imag[n], 2));      // |signal[n]|^2 = |sig_real[n]|^2 + |sig_imag[n]|^2
		// TEST: printf("signal[%d] = %f\n", n, signal[n]);
	}
}

void lowtime_liftering(double* cepstrum, double* low_lifter_cc, int N_PT, int lifter_point) {
	for (int n = 0; n < N_PT; n++) {
		if (n < lifter_point || n >= N - lifter_point)
			low_lifter_cc[n] = cepstrum[n];
		else low_lifter_cc[n] = 0.0;
	}
	//TEST: for (int n = 0; n < N_PT; n++) printf("low_lifter_cc[%d] = %f\n", n, low_lifter_cc[n]);
}

void hightime_liftering(double* cepstrum, double* high_lifter_cc, int N_PT, int lifter_point) {
	for (int n = 0; n < N_PT; n++) {
		if (N / 2 - lifter_point - 1 < n && n < N / 2 + lifter_point)
			high_lifter_cc[n] = cepstrum[n];
		else high_lifter_cc[n] = 0.0;
	}
	//TEST: for (int n = 0; n < N_PT; n++) printf("high_lifter_cc[%d] = %f\n", n, high_lifter_cc[n]);
}

void get_envlp_file(FILE *fp, double* spec_env, int N_PT) {
	for (int i = 0; i < N_PT; i++) fprintf(fp, "%10.7f\n", spec_env[i]);
}

void get_log_env(FILE *fp, double* spec_mag, int N_PT) {
	for (int i = 0; i < N_PT; i++) {
		fprintf(fp, "%10.7f\n", log10(spec_mag[i]));
	}
}