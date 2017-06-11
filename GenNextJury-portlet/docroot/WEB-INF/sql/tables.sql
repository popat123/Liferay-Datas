create table GnNext_Jurys (
	jurysId LONG not null primary key,
	name VARCHAR(75) null,
	companyName VARCHAR(75) null,
	category VARCHAR(75) null,
	juryImage LONG,
	shortDescription STRING null,
	longDescription STRING null,
	number_ LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);