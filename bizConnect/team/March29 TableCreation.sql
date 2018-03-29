USE bizconnect;
CREATE TABLE `user_activity` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(45) NOT NULL,
  `SECURE_TOKEN` varchar(45) default NULL,
  `LOGIN_TIME` varchar(45) default NULL,
  `LOGOUT_TIME` varchar(100) default NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) NOT NULL,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `EMAIL_ADDRESS` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `CONFIRM_PASSWORD` varchar(100) not null,
  `PHONE_NUMBER` varchar(12) DEFAULT NULL,
  `ZIP_CODE` varchar(6) default NULL,
  `PROFILE_IMAGE_ID` varchar(255) default NULL,  
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
CREATE TABLE `user_profile_image` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROFILE_IMAGE_URL` varchar(45) default NULL,
  `USER_NAME` varchar(45),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
