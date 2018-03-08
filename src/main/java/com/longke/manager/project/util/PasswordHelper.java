package com.longke.manager.project.util;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.longke.manager.project.entity.generator.SysUser;

/**
 * 
 * ClassName		:	PasswordHelper <br/>
 * Function			:	密码管理器. <br/>
 * date				:	2018年3月5日 下午2:48:29 <br/>
 *
 * @author 			:	Alex Hu
 * @version 		:	
 * @since 			:	JDK 1.8
 */
public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(SysUser sysUser) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName, sysUser.getPassword(),  ByteSource.Util.bytes(sysUser.getUsername()), hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		sysUser.setPassword(newPassword);

	}
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		SysUser user = new SysUser();
		user.setUsername("admin");
		user.setPassword("admin");
		passwordHelper.encryptPassword(user);
		System.out.println(user);
	}
}
