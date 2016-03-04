package org.gitmining.api.dao;

public class MongoInfo {
	public static final String DB ="ghcrawlerV3";
	public static final String REPO_COLLECTION ="repository";
	public static final String COMMIT_COLLLECTION ="commitsbyapi";
	public static final String PULL_COLLECTION ="pullscp";
	public static final String ISSUE_COLLECTION ="issuescp";
	public static final String USER_COLLECTION ="user";
	public static final String LANGUAGE_COLLECTION ="languages";
	public static final String CONTRIBUTOR_COLLECTION ="contributors";
	public static final String COLLABORATOR_COLLECTION ="assignees";
	public static final String BRANCH_COLLECTION ="branches";
	public static final String FORK_COLLECTION ="forks";
	public static final String STAR_COLLECTION ="stargazers";
	public static final String SUBSCRIBER_COLLECTION ="subscribers";
	public static final String COMMENT_COLLECTION ="comment";
	public static final String ISSUE_COMMENT_COLLECTION ="issuecomment";
	
	public static String getMongoServerIp(){
		String remoteIP = "121.41.118.191";
		String localhost = "127.0.0.1";
		return remoteIP;
	}
}
