create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

insert into oauth_client_details values('client','work','secret','read','password','http://www.google.co.in','user',10000,10000,'{}','true')

-- for authorization code grant type
-- insert into oauth_client_details values('client','work','secret','read','authorization_code','http://www.google.co.in','user',10000,10000,'{}','true')