@echo off
echo This batch file installs the DLLs required to use MPXJ into the GAC
pause
gacutil /i IKVM.AWT.WinForms.dll
gacutil /i IKVM.OpenJDK.Beans.dll
gacutil /i IKVM.OpenJDK.Charsets.dll
gacutil /i IKVM.OpenJDK.Cldrdata.dll
gacutil /i IKVM.OpenJDK.Corba.dll
gacutil /i IKVM.OpenJDK.Core.dll
gacutil /i IKVM.OpenJDK.Jdbc.dll
gacutil /i IKVM.OpenJDK.Localedata.dll
gacutil /i IKVM.OpenJDK.Management.dll
gacutil /i IKVM.OpenJDK.Media.dll
gacutil /i IKVM.OpenJDK.Misc.dll
gacutil /i IKVM.OpenJDK.Naming.dll
gacutil /i IKVM.OpenJDK.Nashorn.dll
gacutil /i IKVM.OpenJDK.Remoting.dll
gacutil /i IKVM.OpenJDK.Security.dll
gacutil /i IKVM.OpenJDK.SwingAWT.dll
gacutil /i IKVM.OpenJDK.Text.dll
gacutil /i IKVM.OpenJDK.Tools.dll
gacutil /i IKVM.OpenJDK.Util.dll
gacutil /i IKVM.OpenJDK.XML.API.dll
gacutil /i IKVM.OpenJDK.XML.Bind.dll
gacutil /i IKVM.OpenJDK.XML.Crypto.dll
gacutil /i IKVM.OpenJDK.XML.Parse.dll
gacutil /i IKVM.OpenJDK.XML.Transform.dll
gacutil /i IKVM.OpenJDK.XML.WebServices.dll
gacutil /i IKVM.OpenJDK.XML.XPath.dll
gacutil /i IKVM.Reflection.dll
gacutil /i IKVM.Runtime.JNI.dll
gacutil /i IKVM.Runtime.dll
gacutil /i commons-collections4-4.1.dll
gacutil /i ikvm-native-win32-x64.dll
gacutil /i ikvm-native-win32-x86.dll
gacutil /i junit.dll
gacutil /i mpxj-for-csharp.dll
gacutil /i mpxj-for-vb.dll
gacutil /i mpxj-test.dll
gacutil /i mpxj.dll
gacutil /i poi-3.17.dll
gacutil /i rtfparserkit-1.13.0.dll
gacutil /i sqlite-jdbc-3.8.10.1.dll