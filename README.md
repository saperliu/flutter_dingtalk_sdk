# flutter_dingtalk_sdk

![pub package](https://img.shields.io/pub/v/flutter_dingtalk_sdk.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](./LICENSE)

## What is the flutter_dingtalk_sdk

`flutter_dingtalk_sdk` Is a [Dingtalk nailing SDK](https://developers.dingtalk.com/document/mobile-app-guide) plug-in, which allows developers to invoke
[Nail the native SDK](https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html).

[中文请移步此处](./README_CN.md)

## Installation

'flutter_dingtalk_sdk' dependency to the 'pubspec.yaml' file:

```yaml
dependencies:
  flutter_dingtalk_sdk: ^1.0.4
```

## android

```groovy
buildscript {
    dependencies {
        classpath 'com.android.tools.build:gradle:4.1.0'
    }
}
```

## ios

``` xml
In Xcode, select your project Settings, select Targets, and in the Info TAB's URL Type, add "URL Scheme" as the ID of your registered application

URL Types
tencent: identifier=tencent schemes=appId
```

``` xml
IOS 9 system policy update restricts HTTP protocol access. In addition, applications need to whitelist URL Schemes that will be used in "Info.plist" to check whether other applications are installed or not.
<key>LSApplicationQueriesSchemes</key>
<array>
  <string>dingtalk</string>
  <string>dingtalk-open</string>
  <string>dingtalk-sso</string>
</array>
```

## flutter

``` text
  Flutter 2.2.2 • channel stable nullsafety
  Framework • revision d79295af24 (9 days ago) • 2021-06-11 08:56:01 -0700
  Engine • revision 91c9fc8fe0
  Tools • Dart 2.13.3
```

## Ability to

- Share pictures, text, music, videos, etc.
- Nail in.
- Open the nail.

## Prepare

`flutter_dingtalk_sdk` You can do a lot of work but not everything. Before integrating, it's a good idea to read the [official documentation](https://developers.dingtalk.com/document/mobile-app-guide).  

## Register WxAPI

through `FluDing` RegisterWxApi.

```dart
FluDing.registerApp("dingu6xwfjbghhqtwwzu");
```

For Android, see [article](https://developers.dingtalk.com/document/mobile-app-guide/sdk-download?spm=ding_open_doc.document.0.0.350710afk92z1R#section-gz5-iof-0ni)To see how to get an app signature.
Then you need to know the difference between the app signature for release and debug. If you don't sign it right, you'll get an error `errCode = -1`.

## Ability to document

- [Login](./doc/AUTH_CN.md)
- [Share](./doc/SHARE_CN.md)

For more features, look at the source code.

## QA

[These questions may be helpful to you](./doc/QA_CN.md)
