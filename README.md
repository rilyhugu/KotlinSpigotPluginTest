# Kotlinのspigot api用のテンプレート

## 変更する場所リスト


### クラスを作成

IDEのrefactorでTemplateClass.ktをrenameする。
クラス名は最初も大文字が推奨らしい
* src/main/kotlin/

以下みたいになる

* src/main/kotlin/SpigotBalloon.kt

その後パッケージを自分のパッケージ名にする。 俺の場合だと

```kotlin
package jp.faketuna.projectname
```

になる

---

### build.gradle.kts

* group: パッケージ名
* version: プラグインバージョン
* mcVersion: マイクラのバージョン(Apiをダウンロードするために必要)

#### BukkitDescription

詳細はこの[リンク](https://github.com/Minecrell/plugin-yml)のkotlin-dslを参照

* main: メイン関数への経路 Kotlinの場合 クラス名がa.ktでパッケージがhelp.meだった場合 help.me.a となる
* apiVersion: どのバージョンで作られたプラグイン化をbukkitに通知, 基本的にはマイナーバージョンまで入れる
* 詳細はサイトからお願いします。

---

#### application

メインクラスのクラス名を指定

---

### settings.gradle.kts

プロジェクト名を指定
例としては: spigotBalloon など
