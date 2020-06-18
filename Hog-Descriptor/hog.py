import numpy as np
import cv2 as cv

class HogExtractor:
    """
    Histogram of Oriented Gradients (HOG)
    HOG is feature descriptor used in Computer Vision and Image Processing for the purpose of Object detection.

    Usage:
        >>> import cv2 as cv
        >>> from hog import HogExtractor
        >>> image = cv.imread("image.jpg", cv.IMREAD_GRAYSCALE)
        >>> filter = [[-1, 0, 1], [-2, 0, 2], [-1, 0, 1]]
        >>> hog = HogDescriptor(filter)
        >>> hog.extract(image, filter)
    """

    def __init__(self):
        pass

    def extract(self, image, padding = 1, stride = 1):
        """ Implementation is under way """
        sobel_h = np.array([[-1, 0, 1]])
        sobel_v = np.array([[-1, 0, 1]]).transpose((0, 1))

        image = cv.resize(image, (64, 128), interpolation=cv.INTER_CUBIC)
        gx = self.get_cross_corr2d(matrix = image, filter = sobel_h, padding = padding, stride = stride)
        gy = self.get_cross_corr2d(matrix = image, filter = sobel_v, padding = padding, stride = stride)
        magnitude = np.sqrt(gx * gx + gy * gy)
        print(magnitude)
        angle = np.arctan2(gy, gx) * 180 / np.pi
        print(angle)

    def get_cross_corr2d(self, matrix, filter, padding = 1, stride = 1):
        """ get cross-correlation matrix & filter """
        MATRIX_H, MATRIX_W = matrix.shape
        FILTER_H, FILTER_W = filter.shape
        CORR_H = int((MATRIX_H + 2 * padding - FILTER_H) / stride) + 1
        CORR_W = int((MATRIX_W + 2 * padding - FILTER_W) / stride) + 1
        matrix = self.zero_padding(matrix, padding)
        cross_corr = np.empty((CORR_H, CORR_W))
        matrix_x, matrix_y = 0, 0

        for x in range(CORR_H):
            for y in range(CORR_W):
                cross_corr[x, y] = (matrix[matrix_x : matrix_x + FILTER_H, matrix_y : matrix_y + FILTER_W] * filter).sum()
                matrix_y += stride
            matrix_x += stride
            matrix_y = 0
        return cross_corr

    def zero_padding(self, matrix, padding = 1):
        """
        add zero-padding to matrix

        Usage:
            >>> import numpy as np
            >>> matrix = np.ones((3, 3))
            >>> matrix = zero_padding(matrix, padding = 1)
            >>> print(matrix)
            [[0. 0. 0. 0. 0.]
             [0. 1. 1. 1. 0.]
             [0. 1. 1. 1. 0.]
             [0. 1. 1. 1. 0.]
             [0. 0. 0. 0. 0.]]
        """
        MATRIX_H, MATRIX_W = matrix.shape
        new_matrix = np.zeros((MATRIX_H + 2 * padding, MATRIX_W + 2 * padding))
        new_matrix[padding:-padding, padding:-padding] = matrix
        return new_matrix

if __name__ == '__main__':
    hog = HogExtractor()
    image = cv.imread("./image/dogs.jpg", cv.IMREAD_GRAYSCALE)
    hog.extract(image, padding=1, stride=1)