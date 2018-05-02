/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.mainpkg;

/**
 *
 * @author DynamicSP
 */
public class LoggerClass {
    private String LoggerClass;
    private String LoggerPackage;
    
    LoggerClass(String Class, String Package) {
        LoggerClass=Class;
        LoggerPackage=Package;
    }

    public String getLoggerClass() {
        return LoggerClass;
    }

    public void setLoggerClass(String loggerClass) {
        this.LoggerClass = loggerClass;
    }

    public String getLoggerPackage() {
        return LoggerPackage;
    }

    public void setLoggerPackage(String LoggerPackage) {
        this.LoggerPackage = LoggerPackage;
    }
    
   
}
