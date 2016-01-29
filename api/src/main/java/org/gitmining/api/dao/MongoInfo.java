package org.gitmining.api.dao;

public class MongoInfo {
	public static final String DB ="ghcrawlerV3";
	public static final String REPO_COLLECTION ="repository";
	public static final String COMMIT_COLLLECTION ="";
	public static final String PULL_COLLECTION ="";
	public static final String LANGUAGE_COLLECTION ="languages";
	
	
	public static String getMongoServerIp(){
		String remoteIP = "121.41.118.191";
		String localhost = "127.0.0.1";
		return remoteIP;
	}
}
