package io.github.furstenheim;

import io.github.furstenheim.copy.CopyDown;

public class Main {
    public static void main(String[] args) {
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
    }
}