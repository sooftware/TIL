package customer2;

public interface PublicConstants {
	public static final int MENU_NUM = 7;
	public static final int PRINT_CUSTOMER_LIST = 0;
	public static final int REGISTER_NEW_CUSTOMER = 1;
	public static final int MODIFY_CUSTOMER_INFO = 2;
	public static final int LOOKUP_CUSTOMER_POINT = 3;
	public static final int DELETE_CUSTOMER = 4;
	public static final int EXIT = 5;
	public static final String TITLE = "\n\t### Customer Management Program v1.1 ###\n";
	public static final String[] MENUS = {"## 0. 고객 명단 출력\n",
										 "## 1. 신규 고객 등록\n",
										 "## 2. 고객 정보 수정\n",
										 "## 3. 고객 포인트 조회\n",
										 "## 4. 고객 삭제\n",
										 "## 5. 프로그램 종료\n",
										 ">> Input : "}; 
	public static final String INT_MISMATCH_EXCEPT_MSG = "잘못입력했습니다!! 정수로 다시 입력해주세요.";
	public static final String FATAL_ELSE_MSG = "발생하면 안 되는 else가 발생했습니다!!";
	public static final String NO_EXIST_CUSTOMER_MSG = "고객 명단이 없습니다!!";
	public static final String INVALID_CUSTOMER_NO_MSG = "해당 고객 번호는 존재하지 않습니다!! 다시 입력하세요";
	public static final String MODIFY_CUSTOMER_MSG = ">> 수정하고 싶은 고객님의 고객 번호를 입력하세요 : ";
	public static final String LOOKUP_CUSTOMER_MSG = ">> 조회를 원하는 고객님의 고객 번호를 입력하세요 : ";
	public static final String DELETE_CUSTOMER_MSG = ">> 삭제를 원하는 고객님의 고객 번호를 입력하세요 : ";
	public static final String CNO_ALREADY_EXIST_MSG = ">> 이미 존재하는 번호입니다. 다시 입력해주세요.";
	public static final String ADMIN_LOGIN_ID_MSG = "관리자 권한이 필요합니다.\n>> ADMIN ID : ";
	public static final String ADMIN_LOGIN_PASSWD_MSG = ">> ADMIN PASSWORD : ";
	public static final String ADMIN_LOGIN_FAIL_MSG = "관리자 권한 접근에 실패하셨습니다.";
	public static final String CNO_INPUT_MSG = ">> 고객 번호 : ";
	public static final String PNUM_INPUT_MSG = ">> 핸드폰 번호 : ";
	public static final String CNAME_INPUT_MSG = ">> 고객 이름 : ";
	public static final String GENDER_INPUT_MSG = ">> 성별 : ";
	public static final String POINT_INPUT_MSG = ">> 포인트 : ";
	public static final String PASSWD_INPUT_MSG = ">> 비밀번호 : ";
	public static final String PASSWD_CHECK_MSG = ">> 비밀번호 재확인 : ";
	public static final String PASSWD_MISMATCH_MSG = ">> 비밀번호가 서로 다릅니다. 다시 입력해주세요.";
	public static final String CUSTOMER_TABLE_NAME = "CUSTOMER_TABLE";
	public static final String DB_NOT_CONN_MSG = "데이터베이스와 연결이 되지 않았습니다\n프로그램이 종료됩니다..";
	public static final String DB_CONN_MSG = "데이터베이스와 연결 되었습니다!!";
	public static final String TAP = "\t";
	public static final String SQL_COMMA = "','";
	public static final String SQL_INT_COMMA = ",";
	public static final String SQL_OPEN = "('";
	public static final String SQL_CLOSE = "');";
	public static final String SQL_INT_CLOSE = ")";
	public static final String ADMIN_TABLE_NAME = "ADMIN_LIST";
	public static final String UPDATE_ATTR_MSG = ">> 수정하고자 하는 속성 : ";
	public static final String UPDATE_VALUE_MSG = ">> 수정하고자 하는 값 : ";
	public static final String DB_LOGIN_ID_MSG = "ORACLE ID : ";
	public static final String DB_LOGIN_PASSWD_MSG = "ORACLE PASSWD : ";
	public static final String[] CUSTOMER_TABLE_ATTRS = {"CUSTOMER_NO",
														 "CUSTOMER_NAME",
														 "PHONE_NUM",
														 "GENDER",
														 "POINT_"};
}
