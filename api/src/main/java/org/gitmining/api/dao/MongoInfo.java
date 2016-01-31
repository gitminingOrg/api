package org.gitmining.api.dao;

public class MongoInfo {
	public static final String DB ="ghcrawlerV3";
	public static final String REPO_COLLECTION ="repository";
	public static final String COMMIT_COLLLECTION ="";
	public static final String PULL_COLLECTION ="";
	public static final String LANGUAGE_COLLECTION ="languages";
	public static final String CONTRIBUTOR_COLLECTION ="contributors";
	public static final String COLLABORATOR_COLLECTION ="assignees";
	
	public static String getMongoServerIp(){
		String remoteIP = "121.41.118.191";
		String localhost = "127.0.0.1";
		return remoteIP;
	}
}
