package util;

import java.io.File;
import java.io.FilenameFilter;

public class ScanDirectory implements FilenameFilter {
	String[] list;
	String ends;
	
	public ScanDirectory(String dirname, String ends){
		this.ends=ends.toLowerCase();
		this.list = (new File(dirname)).list(this);
	}
	
	// lista dei nomi dei file
	public String[] list() {
		return list;
	}
	
	// realizzazione del FilenameFilter
	public boolean accept(File dir, String s){
		return s.toLowerCase().endsWith(ends);
	}
}
