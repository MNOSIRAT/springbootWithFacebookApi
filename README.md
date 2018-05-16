# springbootWithFacebookApi
spring boot app use facebook as log in to users and request some  additional permissions such as "user_like"


you must firstly create text users as here  https://developers.facebook.com/docs/apps/test-users


and set in facebook in app Client OAuth Settings / Valid OAuth Redirect URIs the vales "https://localhost:8443/connect/facebook"
where my reference was https://developers.facebook.com/blog/post/2017/12/18/strict-uri-matching/

then the program will work,
probably :) .
