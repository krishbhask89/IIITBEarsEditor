/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitb.EarsEditor.Controller;

import iiitb.EarsEditor.Model.EARSRequirement;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Krish
 */
public class RequirementFile {
    public ArrayList<EARSRequirement> _FileReqList;
    private String _fileName;
    private String _fileFormat;
    //public BasePanel _fileReqPanel;
    
    public RequirementFile(BasePanel reqPanel){
    	this._fileName = "Untitled";
    	this._fileReqPanel = reqPanel;
    	this._FileReqList = new ArrayList();
    }
    
    public void _OnSaveAs(String _fName){
    	this._fileName = _fName;
    	loadReqs();
    }
    
    public void loadReqs(){
    	//loads Requirements from the panel corresponding to the file into the ArrayList
        JTable panelTable = _fileReqPanel.getTable();
        int rCnt = panelTable.getRowCount();
        for(int i =0; i< rCnt; i++)
        { LeftPanel ceLP = (LeftPanel) panelTable.getModel().getValueAt(i,0);
          Component[] _lpComps = ceLP.getCompone  
        }
    	JTable table = new JTable();
        table.getRowCount();
    }
    
    public void _OnSave(){
    	//when the Save button is clicked for the File
    	loadReqs();
    }
}
