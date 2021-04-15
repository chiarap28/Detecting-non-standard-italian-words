package util;

public class SystemData {

	private static Runtime R = Runtime.getRuntime();
	private static double time0;

	public static void initTime() {
		time0 = System.currentTimeMillis();
	}

	public static double askTime() {
		return (System.currentTimeMillis() - time0) / 1000.;
	}

	public static double askMemory() {
		R.gc();
		return (R.totalMemory() - R.freeMemory()) / 1024. / 1024.;
	}
	
}
