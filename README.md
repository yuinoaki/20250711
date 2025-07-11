# GitHub Actions Java Demo Project

このプロジェクトは、GitHub Actions を使用した Java プロジェクトの CI/CD パイプラインのデモです

## 機能

- **Maven ビルド**: Java 11 と 17 の両方でビルドとテスト
- **単体テスト**: JUnit 5 を使用した自動テスト
- **静的解析**: SpotBugs による静的コード解析
- **テストレポート**: 自動生成されるテスト結果レポート
- **アーティファクト管理**: ビルド成果物の自動保存

## プロジェクト構造

```
.
├── .github/
│   └── workflows/
│       └── maven-ci.yml        # GitHub Actions ワークフロー定義
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/demo/
│   │           ├── Calculator.java    # 計算機能クラス
│   │           └── StringUtils.java   # 文字列操作ユーティリティ
│   └── test/
│       └── java/
│           └── com/example/demo/
│               ├── CalculatorTest.java    # Calculator のテスト
│               └── StringUtilsTest.java   # StringUtils のテスト
├── pom.xml                     # Maven プロジェクト設定
└── README.md                   # このファイル
```

## ローカルでの実行方法

### 前提条件
- Java 11 以上
- Maven 3.6 以上

### ビルドとテスト
```bash
# プロジェクトのビルド
mvn clean compile

# テストの実行
mvn test

# 静的解析の実行
mvn spotbugs:check

# パッケージの作成
mvn package
```

## GitHub Actions ワークフロー

ワークフローは以下のタイミングで自動実行されます：
- `main` または `develop` ブランチへのプッシュ時
- `main` ブランチへのプルリクエスト時

### ワークフローの内容

1. **マルチバージョンテスト**: Java 11 と 17 で並行実行
2. **ビルド**: Maven によるコンパイル
3. **テスト**: JUnit 5 によるユニットテスト
4. **レポート生成**: テスト結果の可視化
5. **静的解析**: SpotBugs によるコード品質チェック
6. **アーティファクト保存**: JAR ファイルの保存

## 使用技術

- **Java**: 11/17
- **Maven**: ビルドツール
- **JUnit 5**: テストフレームワーク
- **SpotBugs**: 静的解析ツール
- **GitHub Actions**: CI/CD プラットフォーム
