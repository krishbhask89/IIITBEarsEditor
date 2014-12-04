/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myearseditor.controller;

import java.util.ArrayList;
import myearseditor.View.BasePanel;
import myearseditor.model.EARSRequirement;

/**
 *
 * @author Krish
 */
public class RequirementFile {
    public ArrayList<EARSRequirement> _FileReqList;
    private String _fileName;
    //private String _fileFormat;
    //enum ColourCode{RED,GREEN,GREY};
    //private ColourCode _fileColourCode;
    
    public RequirementFile(BasePanel _reqBp){
    	this._fileName = "Untitled";
    	//this._reqPanel = _reqBp;
    	this._FileReqList = new ArrayList();
    	//this._fileColourCode = ColourCode.RED;
    }
    
    public void _OnSaveAs(String _fName){
    	this._fileName = _fName;
    	loadReqs();
    	//when the SaveAs has been clicked for the File
    }
    
    public void loadReqs(){
    	//loads Requirements from the BasePanel into the Vector _FileReqList
    	
    }
    
    public void _OnSave(){
    	//when the Save button is clicked for the File
    	loadReqs();
    }
}
