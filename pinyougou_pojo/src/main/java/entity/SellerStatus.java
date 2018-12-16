package entity;

public class SellerStatus {
//	状态值：  0：未审核   1：已审核   2：审核未通过   3：关闭 

	private static String INIT = "0";
	private static String ACTIVE = "1";
	private static String REFUSE = "2";
	private static String CLOSE = "3";
	public static String getINIT() {
		return INIT;
	}
	public static void setINIT(String iNIT) {
		INIT = iNIT;
	}
	public static String getACTIVE() {
		return ACTIVE;
	}
	public static void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}
	public static String getREFUSE() {
		return REFUSE;
	}
	public static void setREFUSE(String rEFUSE) {
		REFUSE = rEFUSE;
	}
	public static String getCLOSE() {
		return CLOSE;
	}
	public static void setCLOSE(String cLOSE) {
		CLOSE = cLOSE;
	}
	
	
	
}
