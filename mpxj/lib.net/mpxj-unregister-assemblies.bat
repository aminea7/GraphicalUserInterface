@echo off
echo This batch file deregisters the .Net assemblies used by MPXJ so that they are no longer available to be called from COM
pause
regasm /u IKVM.AWT.WinForms.dll
regasm /u IKVM.OpenJDK.Beans.dll
regasm /u IKVM.OpenJDK.Charsets.dll
regasm /u IKVM.OpenJDK.Cldrdata.dll
regasm /u IKVM.OpenJDK.Corba.dll
regasm /u IKVM.OpenJDK.Core.dll
regasm /u IKVM.OpenJDK.Jdbc.dll
regasm /u IKVM.OpenJDK.Localedata.dll
regasm /u IKVM.OpenJDK.Management.dll
regasm /u IKVM.OpenJDK.Media.dll
regasm /u IKVM.OpenJDK.Misc.dll
regasm /u IKVM.OpenJDK.Naming.dll
regasm /u IKVM.OpenJDK.Nashorn.dll
regasm /u IKVM.OpenJDK.Remoting.dll
regasm /u IKVM.OpenJDK.Security.dll
regasm /u IKVM.OpenJDK.SwingAWT.dll
regasm /u IKVM.OpenJDK.Text.dll
regasm /u IKVM.OpenJDK.Tools.dll
regasm /u IKVM.OpenJDK.Util.dll
regasm /u IKVM.OpenJDK.XML.API.dll
regasm /u IKVM.OpenJDK.XML.Bind.dll
regasm /u IKVM.OpenJDK.XML.Crypto.dll
regasm /u IKVM.OpenJDK.XML.Parse.dll
regasm /u IKVM.OpenJDK.XML.Transform.dll
regasm /u IKVM.OpenJDK.XML.WebServices.dll
regasm /u IKVM.OpenJDK.XML.XPath.dll
regasm /u IKVM.Reflection.dll
regasm /u IKVM.Runtime.JNI.dll
regasm /u IKVM.Runtime.dll
regasm /u commons-collections4-4.1.dll
regasm /u ikvm-native-win32-x64.dll
regasm /u ikvm-native-win32-x86.dll
regasm /u junit.dll
regasm /u mpxj-for-csharp.dll
regasm /u mpxj-for-vb.dll
regasm /u mpxj-test.dll
regasm /u mpxj.dll
regasm /u poi-3.17.dll
regasm /u rtfparserkit-1.13.0.dll
regasm /u sqlite-jdbc-3.8.10.1.dll
