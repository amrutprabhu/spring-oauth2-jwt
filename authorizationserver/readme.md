# Work with Spring authorization server

## For password grant type

```
curl -i -X POST -u "client:secret" --header "Content-Type:application/x-www-form-urlencoded" localhost:8080/oauth/token -d grant_type=password -d username=amrut -d password=prabhu
```
Output:

```
HTTP/1.1 200
Pragma: no-cache
Cache-Control: no-store
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sat, 27 Jul 2019 20:06:13 GMT

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid29yayJdLCJ1c2VyX25hbWUiOiJhbXJ1dCIsInNjb3BlIjpbInJlYWQiXSwiZXhwIjoxNTY0MjY3OTcyLCJhdXRob3JpdGllcyI6WyJST0xFX3VzZXIiXSwianRpIjoiZTI1YzNlMmUtZmZjNS00ODRjLWFiYTEtNmQ4YWI1ZDVkNWNlIiwiY2xpZW50X2lkIjoiY2xpZW50In0.vnq1R3k3-ovZ_nPfzoqRx50L6i7KPZwgvc1PS2zXSk0","token_type":"bearer","expires_in":9999,"scope":"read","jti":"e25c3e2e-ffc5-484c-aba1-6d8ab5d5d5ce"}
```

## To use authorization_code grant type

Default url
`/oauth/authorize`

Requirement
1. Login form needed in websecurity to enter username and password
2. need redirect uri to be registered for client.
3. grant type has to be provided `authorization_code`


In browser
```
http://localhost:8080/oauth/authorize?client_id=client&response_type=code&scope=read&redirect_uri=http://www.google.co.in
```

After getting authorization code

```
curl -i -X POST -u "client:secret" --header "Content-Type:application/x-www-form-urlencoded" localhost:8080/oauth/token -d code=2U6Tq8 -d grant_type=authorization_code -d redirect_uri=http://www.google.co.in
```

Output:

```
HTTP/1.1 200
Pragma: no-cache
Cache-Control: no-store
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sat, 27 Jul 2019 19:56:14 GMT

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid29yayJdLCJ1c2VyX25hbWUiOiJhbXJ1dCIsInNjb3BlIjpbInJlYWQiXSwiZXhwIjoxNTY0MjY3Mzc0LCJhdXRob3JpdGllcyI6WyJST0xFX3VzZXIiXSwianRpIjoiOTNiMmM2MDMtYzM1OC00MTRiLWIxZGYtYTQwM2VlNDFjZjZiIiwiY2xpZW50X2lkIjoiY2xpZW50In0.XzKzmbpXJD4MgBqOEncdQlTejT8AkKlxYhLKoXN74lE","token_type":"bearer","expires_in":9999,"scope":"read","jti":"93b2c603-c358-414b-b1df-a403ee41cf6b"}⏎
```

### Approval from user
After the user authenticates, we can ask for scope approval like read scope etc.
Set the approval handler in the authorization server endpoint.
