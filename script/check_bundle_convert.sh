
java -jar bundletool-all-1.15.6.jar build-apks --bundle=obfuscated-app.aab --output=out.apks --connected-device
java -jar bundletool-all-1.15.6.jar install-apks --apks=out.apks
