## 演習の環境設定手順

1. 「[Oracleインスタントクライアントのダウンロード](http://www.oracle.com/technetwork/jp/topics/index-099943-ja.html)から以下をダウンロードし、展開。<br />
「instantclient_12_1」ディレクトリが作成されていることを確認
	* instantclient-basic-linux.x64-12.1.0.2.0.zip
	* instantclient-sqlplus-linux.x64-12.1.0.1.0.zip<br /><br />
1. 「非同期IO(libio)」のインストール<br />
$ sudo aptitude install libaio1<br /><br />
1. 「リードラインラッパー(rlwrap)」のインストール<br />
$ sudo aptitude install rlwrap<br /><br />
1. 「[oracle.2014](https://github.com/KimiyukiYamauchi/oracle.2014.git)」を「git clone」
<br />$ git clone https://github.com/KimiyukiYamauchi/oracle.2014.git (任意のディレクトリ名)<br /><br />
2. リモートリポジトリ「origin」を別の名前に変える
<br />$ git remote rename origin  (任意の別名)<br /><br />
3. 各自のGithubに演習をアップするためのリポジトリを作成<br /><br />
4. 上で作成したリモートリポジトリに「origin」と名前をつける
<br />$ git remote add origin  (各自のリモートリポジトリのURL)<br /><br />
5. ローカルリポジトリをリモートのpushする
<br />$ git push -u origin master<br /><br />
6. Oracleサーバへの接続確認
	1. 接続のためのスクリプトを作成<br />
$ vi sqlplus.sh<br >
で、ファイルを開き、以下を入力。<br />
この時、「instantclient_12_1」ディレクトリのパスは各自の環境に<br />
沿って、記述すること<br /><br />
LD_LIBRARY_PATH=/home/yamauchi/instantclient_12_1<br />
PATH=/home/yamauchi/instantclient_12_1:$PATH<br />
NLS_LANG=JAPANESE_JAPAN.AL32UTF8<br />
export LD_LIBRARY_PATH PATH NLS_LANG<br />
export no_proxy=localhost,172.16.40.4<br />
echo -n "ユーザ名："<br />
read user<br />
stty -echo<br />
echo -n "パスワード："<br />
read pass<br />
stty echo<br />
rlwrap sqlplus $user/$pass@172.16.40.4:1521/db11<br /><br />
	2. 作成したスクリプトを実行し、接続できること<br />
$ ./sqlplus.sh<br />
ユーザ名：hr<br />
パスワード：hr (パスワードの入力はエコーバックしないので注意！)<br />
=> これで接続できること！ <br /><br />
6. 演習環境の設定
	1. 演習用のアカウントでサーバに接続<br />
$ ./sqlplus.sh<br />
ユーザ名：(学籍番号)<br />
パスワード：password (パスワードの入力はエコーバックしないので注意！)<br />
=> 各自のアカウントで接続される <br /><br />
	1. 演習用のテーブルを作成するためのスクリプトを実行<br />
SQL> @create_tbl_oracle.sql<br /><br />
	1. 以下のSELECT文を実行し、テーブルが作成できていることを確認<br />
また、それぞれのテーブルに対して、SELECT文を実行し、データがちゃんと入っていることを確認<br />
SQL> select table_name from user_tables;<br />
SQL> select tname from tab;

		- ORDERS
		- ORD_DETAILS
		- SALGRADES
		- EMPLOYEES
		- PRODUCTS
		- CUSTOMERS
		- DEPARTMENTS

6. 以降は以下の操作

	* 演習を作成し、講師提出する場合、

		1. 「master」branchに切り替え。
<br />$ git checkout master <br /><br />
		1. 演習の作業を行うbranchを作成し、それにcheckout
<br />$ git checkout -b (演習リポジトリ名) <br /><br />
		1. 演習を行い、成果物をadd, commitで、リポジトリに登録 
<br />$ git add -A
<br />$ git commit -m "コメント"<br /><br />
		1. 演習の成果物を「master」branchにmerge
<br />$ git checkout master 
<br />$ git merge (演習リポジトリ名) <br /><br />
		1. ローカルの「master」をGithubに上げる
<br />$ git push <br /><br />
		1. 講師に演習を作成した旨連絡
			* yamauchi@std.it-college.ac.jp

	* ひな形などの最新を入手する場合、

		1. 「[oracle.2014](https://github.com/KimiyukiYamauchi/oracle.2014.git)」を「git pull」
<br />$ git pull (自分がつけた別名) master<br /><br />

## 演習問題

1. 2014/10/02

	1. employees表のempno列、ename列を取り出すスクリプト(141002-1.sql)
	2. employees表のすべての列を取り出すスクリプト(141002-2.sql)
	3. employees表の表構造を表示するスクリプト(141002-3.sql)
	4. employees表のename列、sal列、sal列に100000を足したものを12倍した列
<br />を取り出すスクリプト(141002-4.sql)
	5. employees表のempno、ename、sal、sal列に100000を足したものを12倍した列<br />
を取り出す、この時、それぞれに社員番号、社員名、給与、年収の別名<br />
をつけるスクリプト(141002-5.sql)

2. 2014/10/07

	1. employees表のjob列を重複を排除して取り出すスクリプト(141007-1.sql)
	2. employees表でenameが「佐藤」のempno、ename、deptno列を取り出す<br />
スクリプト(141007-2.sql)
	3. employees表でhiredateが「2006年10月21日」のempno、ename、hiredate列を<br />
取り出すスクリプト(141007-3.sql)
	4. employees表でsalが「30万以上」のempno、ename、sal列を取り出すスクリプト<br />
(141007-4.sql)
	5. employees表でsalが「20万以上かつ30万以下」のempno、ename、sal列を取り出す<br />
スクリプト(141007-5.sql)

3. 2014/10/08

	1. employees表でdeptnoが「10または20」であるempno、ename、deptno列を取り出す<br />
スクリプト(141008-1.sql)
	2. employees表でdeptnoが「10でも20でもない」empno、ename、deptno列を取り出す<br />
スクリプト(141008-2.sql)
	3. employees表でsalが「20万より少ないまたは30万より多い」場合のempno、ename、sal列<br />
を取り出すスクリプト(141008-3.sql)
	4. products表でpnameに「A4」を含む場合のprodno、pname、price列を取り出す<br />
スクリプト(141008-4.sql)
	5. employees表でcommが「NULL」のempno、ename、sal、comm列を取り出す<br />
スクリプト(141008-5.sql)

4. 2014/10/09

	1. employees表でsalが「30万以上」かつdeptnoが「30」であるempno、ename、<br />
sal、deptno列を取り出すスクリプト(141009-1.sql)
	2. employees表からempno、ename、sal、deptno列を取り出す。この時、salの多い順<br />
にソートする。但し、salが同額の場合にはdeptnoの小さい順でソートするスクリプト<br />
(141009-2.sql)
	3. employees表でdeptnoが置換変数で受け取った値と等しいempno、ename、sal、deptno列<br />
を取り出すスクリプト(141009-3.sql)
	4. products表でpnameに「100%」を含むprodno、pname、price列を取り出すスクリプト<br />
(141009-4.sql)
	5. employees表でcommが「NULL」でないempno、ename、sal、comm列を取り出す<br />
スクリプト(141009-5.sql)
