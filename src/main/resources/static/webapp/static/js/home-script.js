
	// 忘记密码事件
	function forget_password(){
		// 初始化登录信息
		username = "admin"
		password = "123456"
		layer.open({
		  title: '登录信息'
		  ,content: '初始化账号：admin</br>初始化密码：123456'
		}); 
	}