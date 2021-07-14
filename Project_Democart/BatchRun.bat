set projectLocation=C:\Users\User\AppData\Local\Jenkins\.jenkins\workspace\SeleniumTest
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
pause