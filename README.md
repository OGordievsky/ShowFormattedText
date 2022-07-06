# ShowFormatText application
<br/>
<br/>This program shows the contents from text file, after entering it's path on the command line.
<br/>Is launched window of the resolution size set in the properties file. This window shows left-formatted text: 
<br/>Words that do not fit on one line are completely wrapped to the next line. 
<br/>Words that do not fit on a line at all are split in such a way that the maximum number of characters remains on the original line. 
<br/>This program handles newline '\n' breaks.
<br/>The text is displayed with proportional font, for example, Arial (the name can be changed in the properties).
<br/>Each pair of text words is shown in a font that is larger or smaller than the font size for the previous pair. 
<br/>In this case, the size change alternates, for example: 9-12-9-12.
<br/>When redrawing the window, the text is not cut into new lines.
<br/>By pressing the Up and Down keys, the program scrolls line by line.
<br/>The program does not use components that perform text formatting. Only the standard "awt" library is used for shows text into window.
<br/>You can change next settings in "ShowFormattedText.properties": fontName; windowWidth; windowHeight; maxSymbols; someWordsCount.
<br/>
<br/>Before start this program:
<br/>Ensure that your PC have <a href="https://www.java.com/en/download/help/index_installing.html">installed Java 8</a>
<br/>And have <a href="https://git-scm.com/book/en/v2/Getting-Started-Installing-Git">installed Git</a>
<br/>
<br/><b>How to start this program?</b>
<br/>  
<br/>Start from console:
<br/>1. Type in your console next commands:
<br/><b>mkdir c:\projects\ShowFormattedText</b>
<br/><b>cd c:\projects\ShowFormattedText</b>
<br/><b>git clone https://github.com/OGordievsky/ShowFormattedText</b>
<br/><b>cd c:\projects\ShowFormattedText\compiled</b>
<br/><b>java -jar ShowFormattedText-1.0-SNAPSHOT.jar</b>
<br/> 
<br/>Start from IntelliJIDEA or another Java IDE
<br/>1. Walk into yours "projects" directory
<br/>2. In project directory type next console command: <b>git clone https://github.com/OGordievsky/ShowFormattedText</b>
<br/>3. Open you favorite IDE
<br/>4. In yours IDE make next steps:<b> File -> Open -> :\projects\ShowFormattedText</b>
<br/>5. Find main class "ShowFTextApp" into: \ShowFormattedText\src\main\com\example\ShowFTextApp.java
<br/>6. Right click on ShowFTextApp.java select [Run] (green "Play" triangle)
<br/>
<br/>Simple way to start from OS
<br/>1. Click  <a href="https://github.com/OGordievsky/ShowFormattedText/raw/master/compiled/Application.rar">"Download"</a> after that the start upload archive from:
<br/>https://github.com/OGordievsky/ShowFormattedText/tree/master/compiled
<br/>2. Unpack Application.rar into your directory.
<br/>3. Double-click on Start.bat
<br/>
<br/>Enjoy to use
