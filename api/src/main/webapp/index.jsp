<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<title>gitmining-api</title>
<style type="text/css">
	p,br{font-size: 10px}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<h2>This is this the gitmining api site welcome page.</h2>
<h3>Repository Related Api</h3>
<p>1. /api/repository(?page=...)</p>
<p>json格式项目详情列表，一页50个，不加?page=则默认显示第一页内容</p>
<br />

<p>2. /api/repository/names</p>
<p>所有项目全称列表（项目全称=owner登录名/项目名），返回值为String类型的数组</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>3. /api/repository/{owner}/{reponame}</p>
<p>单个项目详情，返回一个json</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:org.bson.Document,返回一个json</p>
<br />

<p>4. /api/repository/{owner}/{reponame}/languages</p>
<p>单个项目编程语言使用情况</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:用&lt;String,Integer&gt;表示的&lt;编程语言,语言使用量&gt;的Map</p>
<br />

<p>5. /api/repository/{owner}/{reponame}/item/{item}</p>
<p>查询单个项目的某项内容</p>
<p>item可接受的参数有：</p>
<p>owner_name:项目所有者登录名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）</p>
<p>html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目 </p>
<p>created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间<p>
<p>size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数 open_issues:open的issue数 subscribers_count:关注者数量<p>
<br />

<p>6. /api/repository/{owner}/{reponame}/contributors</p>
<p>查询单个项目的所有贡献者信息</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>7. /api/repository/{owner}/{reponame}/contributors/login</p>
<p>查询单个项目的所有贡献者的登录名</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>8. /api/repository/{owner}/{reponame}/collaborators</p>
<p>查询单个项目的所有合作者信息</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>9. /api/repository/{owner}/{reponame}/collaborators/login</p>
<p>查询单个项目的所有合作者的登录名</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>10. /api/repository/{owner}/{reponame}/branches</p>
<p>查询单个项目的所有版本</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>11. /api/repository/{owner}/{reponame}/branches/names</p>
<p>查询单个项目的所有版本号</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>12. /api/repository/{owner}/{reponame}/branch/{name}</p>
<p>查询单个项目的某个版本信息</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>返回一个json</p>
<br />

<p>13. /api/repository/{owner}/{reponame}/branch/{name}/item/{item}</p>
<p>查询单个项目的某个版本的某项信息</p>
<p>item可接受的参数有：commit 对应提交的sha值 name 版本号 fn 项目全称</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>14. /api/repository/{owner}/{reponame}/forks</p>
<p>查询单个项目的所有fork项目</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>15. /api/repository/{owner}/{reponame}/forks/names</p>
<p>查询单个项目的所有fork项目的全称</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>16. /api/repository/fork/{owner}/{reponame}</p>
<p>查询某个fork项目的信息</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>返回一个json</p>
<br />

<p>17. /api/repository/fork/{owner}/{reponame}/item/{item}</p>
<p>查询某个fork项目的某项信息</p>
<p>item可接受的参数有：</p>
<p>owner_name:项目所有者登录名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）</p>
<p>html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目 </p>
<p>created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间<p>
<p>size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数 open_issues:open的issue数 subscribers_count:关注者数量<p>
<br />

<h3>CommitIssuePull Related Api</h3>
<p>1. /api/repository/{owner}/{reponame}/pulls(?page=...)</p>
<p>查询单个项目的Pull Request内容,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>2. /api/repository/{owner}/{reponame}/pulls/numbers(?page=...)</p>
<p>查询单个项目的Pull Request编号,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Integer&gt;</p>
<br />

<p>3. /api/repository/{owner}/{reponame}/pull/{number}</p>
<p>查询单个项目的某个Pull Request</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>返回一个json</p>
<br />

<p>4. /api/repository/{owner}/{reponame}/pull/{number}/item/{item}</p>
<p>查询某个Pull Request的某项信息</p>
<p>item可接受的参数有：</p>
<p>state,locked,title,body</p>
<p>user,user_id,user_type</p>
<p>created_at,updates_at,closed_at,merged_at</p>
<br />

<p>5. /api/repository/{owner}/{reponame}/issues(?page=...)</p>
<p>查询单个项目的Issues内容,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>6. /api/repository/{owner}/{reponame}/issues/numbers(?page=...)</p>
<p>查询单个项目的Issue编号,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Integer&gt;</p>
<br />

<p>7. /api/repository/{owner}/{reponame}/issue/{number}</p>
<p>查询单个项目的某个issue</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>返回一个json</p>
<br />

<p>8. /api/repository/{owner}/{reponame}/issue/{number}/item/{item}</p>
<p>查询某个Issue的某项信息</p>
<p>item可接受的参数有：</p>
<p>state,locked,title,body</p>
<p>user,user_id,user_type</p>
<p>created_at,updates_at,closed_at,merged_at</p>
<br />

<p>9. /api/repository/{owner}/{reponame}/commits(?page=...)</p>
<p>查询单个项目的Commits内容,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回一个json</p>
<br />

<p>10. /api/repository/{owner}/{reponame}/commits/shas(?page=...)</p>
<p>查询单个项目的ommit编号,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Integer&gt;</p>
<br />

<p>11. /api/repository/{owner}/{reponame}/commit/{sha}</p>
<p>查询单个项目的某个commit</p>
<p>param: owner 项目所有者登录名  reponame 项目名 sha commit的sha值</p>
<p>返回一个json</p>
<br />

<p>12. /api/repository/{owner}/{reponame}/commit/{sha}/item/{item}</p>
<p>查询某个commit的某项信息</p>
<p>item可接受的参数有：</p>
<p>committer,committer_email,Date,message</p>
<p>filenumber 更改文件数,additions 添加代码行数,deletions 删除代码行数,total 总共影响行数</p>
<br />

<p>13. /api/repository/{owner}/{reponame}/issue/{number}/comments</p>
<p>查询单个项目的某个issue的评论</p>
<p>param: owner 项目所有者登录名  reponame 项目名 number issue的number值</p>
<p>返回json</p>
<br />

<p>14. /api/repository/{owner}/{reponame}/commit/{sha}/comments</p>
<p>查询某个commit的评论</p>
<p>param: owner 项目所有者登录名  reponame 项目名 sha commit的sha值</p>
<p>返回json</p>
<br />

<h3>User Related Api</h3>
<p>1. /api/user/{user}</p>
<p>查询某个user的详细信息（这里的user是项目中contributor或collaborator的登录名）</p>
<p>param: user 登录名</p>
<p>返回json</p>
<br />

<p>2. /api/user/{user}/item/{item}</p>
<p>查询某个user的某项信息（这里的user是项目中contributor或collaborator的登录名）</p>
<p>item可接受的参数有：</p>
<p>id,login,type,name</p>
<p>company,blog,location,email,bio</p>
<p>public_repos,public_gists,followers,following</p>
<p>created_at,updated_at</p>
<br />

<p>3. /api/user/{owner}/{reponame}/stargazers(?page=...)</p>
<p>查询单个项目的点赞者,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回json</p>
<br />

<p>4. /api/user/{owner}/{reponame}/stargazers/names(?page=...)</p>
<p>查询单个项目的点赞者登录名,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />

<p>5. /api/user/{owner}/{reponame}/subscribers(?page=...)</p>
<p>查询单个项目的订阅者,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;Document&gt;,返回json</p>
<br />

<p>6. /api/user/{owner}/{reponame}/subscribers/names(?page=...)</p>
<p>查询单个项目的订阅者登录名,一页50个</p>
<p>param: owner 项目所有者登录名  reponame 项目名</p>
<p>return:List&lt;String&gt;</p>
<br />
</body>
</html>
