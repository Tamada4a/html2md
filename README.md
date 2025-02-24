## Copy Down
Convert HTML into Markdown with Java.

### Installation
#### Gradle:
- Add the JitPack repository to your `build.gradle` file:
```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```
- Add the dependency:
```gradle
dependencies {
    ...
    implementation 'com.github.Tamada4a:html2pdf:-8bf01562a6-1'
}
```

#### Maven:
- Add the JitPack repository to your `pom.xml` file:
```xml
<repositories>
    ...
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
- Add the dependency:
```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.github.Tamada4a</groupId>
        <artifactId>html2pdf</artifactId>
        <version>-8bf01562a6-1</version>
    </dependency>
</dependencies>
```

### JSoup Compatibility

This library has a strong reliance on JSoup. Using a different version of it will lead to unexpected behaviours. Sadly, Java does not allow several versions of a library (unlike Node.js) so if your project is already using JSoup that version will have priority. 

Supported versions are:

| This Library | Jsoup |
| ------------| --------| 
| 1.0  | 1.13 |
| 1.1 | 1.15 |


### Usage

```java

import io.github.furstenheim.CopyDown;
public class Main {
    public static void main (String[] args) {
        CopyDown converter = new CopyDown();
        String myHtml = """
                <h1>Some title</h1>
                <div>
                    Some html<p>Another paragraph</p>
                </div>
                <table>
                  <tr>
                    <td>Emil</td>
                    <td>Tobias</td>
                    <td>Linus</td>
                  </tr>
                  <tr>
                    <td>16</td>
                    <td>14</td>
                    <td>10</td>
                  </tr>
                </table>
                """;
        String markdown = converter.convert(myHtml);
        System.out.println(markdown);
        /*
        *        Prints following:
        *        
        *        Some title
        *        ==========
        *        
        *        Some html
        *        
        *        Another paragraph
        *        
        *        | Emil | Tobias | Linus |
        *        | --- | --- | --- |
        *        | 16 | 14 | 10 |
        */
    }
}
```

### Options

It is possible to use options for converting markdown:

```java
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;

public class Main {
   public static void main (String[] args) {
       OptionsBuilder optionsBuilder = OptionsBuilder.anOptions();
       Options options = optionsBuilder
               .withBr("-")
               // more options
               .build();
       CopyDown converter = new CopyDown(options);
       String myHtml = "<h1>Some title</h1><div>Some html<p>Another paragraph</p></div>";
       String markdown = converter.convert(myHtml);
       System.out.println(markdown);
   }
}
```


| Option                | Valid values  | Default |
| :-------------------- | :------------ | :------ |
| `headingStyle`        | `SETEXT` or `ATX` | `SETEXT`  |
| `hr`                  | Any [Thematic break](http://spec.commonmark.org/0.27/#thematic-breaks) | `* * *` |
| `bulletListMarker`    | `-`, `+`, or `*` | `*` |
| `codeBlockStyle`      | `INDENTED` or `FENCED` | `INDENTED` |
| `fence`               | ` ``` ` or `~~~` | ` ``` ` |
| `emDelimiter`         | `_` or `*` | `_` |
| `strongDelimiter`     | `**` or `__` | `**` |
| `linkStyle`           | `INLINED` or `REFERENCED` | `INLINED` |
| `linkReferenceStyle`  | `FULL`, `COLLAPSED`, or `SHORTCUT` | `FULL` |


### Acknowledgment
This library is a port to Java of the wonderful library [Turndown.js](https://github.com/domchristie/turndown). This library passes the same test suite as the original library to ensure same behavior.

The support to convert tables to markdown is ported from the [turndown-plugin-gfm](https://github.com/mixmark-io/turndown-plugin-gfm) library. It uses also the same test as that library.

This project is supported by Intellij open source license

Forked from [here](https://github.com/tijder/copy-down).