package com.vp.plugin.sample.statediagram.actions;

import java.awt.Point;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IStateDiagramUIModel;
import com.vp.plugin.diagram.connector.ITransition2UIModel;
import com.vp.plugin.diagram.shape.IFinalState2UIModel;
import com.vp.plugin.diagram.shape.IInitialPseudoStateUIModel;
import com.vp.plugin.diagram.shape.IRegionUIModel;
import com.vp.plugin.diagram.shape.IState2UIModel;
import com.vp.plugin.model.IFinalState2;
import com.vp.plugin.model.IInitialPseudoState;
import com.vp.plugin.model.IRegion;
import com.vp.plugin.model.IState2;
import com.vp.plugin.model.ITransition2;
import com.vp.plugin.model.factory.IModelElementFactory;

public class StateDiagramActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// create blank state diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IStateDiagramUIModel diagram = (IStateDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_STATE_DIAGRAM);
		
		// create model for CourseAttempt state
		IState2 stateCourseAttemptModel = IModelElementFactory.instance().createState2();		
		stateCourseAttemptModel.setName("CourseAttempt");
		// create shape for CourseAttempt state
		IState2UIModel stateCourseAttemptShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateCourseAttemptModel);
		// specify its location and size
		stateCourseAttemptShape.setBounds(181, 23, 675, 440);
		// specify the region are on horizontal direction
		stateCourseAttemptShape.setRegionOrientation(IState2UIModel.RO_HORIZONTAL);
		// set to automatic calculate the initial caption position		
		stateCourseAttemptShape.setRequestResetCaption(true);
		
		// create region model under CourseAttempt state model
		IRegion stateCourseAttemptRegionModel = stateCourseAttemptModel.createRegion();
		// create region shape under CourseAttempt state
		IRegionUIModel stateCourseAttemptRegionShape = (IRegionUIModel) diagramManager.createDiagramElement(diagram, stateCourseAttemptRegionModel);
		stateCourseAttemptRegionShape.setBounds(181, 38, 675, 425);
		// add region shape to CourseAppempt in diagram
		stateCourseAttemptShape.addChild(stateCourseAttemptRegionShape);
		
		// create initial pseudo state model
		IInitialPseudoState initialState1Model = IModelElementFactory.instance().createInitialPseudoState();
		// add the initial pseudo state to child of region under CourseAttempt state
		stateCourseAttemptRegionModel.addChild(initialState1Model);	
		// create shape for initial pseudo state
		IInitialPseudoStateUIModel initialState1Shape = (IInitialPseudoStateUIModel) diagramManager.createDiagramElement(diagram, initialState1Model);		
		initialState1Shape.setBounds(320, 67, 20, 20);
		// add initial pseudo state as child of region under CourseAttempt state
		stateCourseAttemptRegionShape.addChild(initialState1Shape);
		
		IState2 stateStudyingModel = IModelElementFactory.instance().createState2();
		stateStudyingModel.setName("Studying");
		stateCourseAttemptRegionModel.addChild(stateStudyingModel);
		IState2UIModel stateStudyingShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateStudyingModel);
		stateStudyingShape.setBounds(270, 117, 497, 239);
		stateStudyingShape.setRegionOrientation(IState2UIModel.RO_HORIZONTAL);
		stateStudyingShape.setRequestResetCaption(true);
		stateCourseAttemptRegionShape.addChild(stateStudyingShape);
		
		// create transition model between initial state and Studying state
		ITransition2 tranInitialStudyingModel = IModelElementFactory.instance().createTransition2();
		// specify the from end as the initial state, and the to end is Studying state 
		tranInitialStudyingModel.setFrom(initialState1Model);
		tranInitialStudyingModel.setTo(stateStudyingModel);
		// create connector into diagram
		diagramManager.createConnector(diagram, tranInitialStudyingModel, initialState1Shape, stateStudyingShape, null);
				
		IRegion studyingRegion1Model = stateStudyingModel.createRegion();
		IRegionUIModel studyingRegion1Shape = (IRegionUIModel) diagramManager.createDiagramElement(diagram, studyingRegion1Model);
		studyingRegion1Shape.setBounds(270, 132, 497, 63);
		stateStudyingShape.addChild(studyingRegion1Shape);
		
		IInitialPseudoState initialState2Model = IModelElementFactory.instance().createInitialPseudoState();
		studyingRegion1Model.addChild(initialState2Model);	
		IInitialPseudoStateUIModel initialState2Shape = (IInitialPseudoStateUIModel) diagramManager.createDiagramElement(diagram, initialState2Model);		
		initialState2Shape.setBounds(300, 152, 20, 20);
		studyingRegion1Shape.addChild(initialState2Shape);
		
		IState2 stateLab1Model = IModelElementFactory.instance().createState2();
		stateLab1Model.setName("Lab1");
		studyingRegion1Model.addChild(stateLab1Model);
		IState2UIModel stateLab1Shape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateLab1Model);
		stateLab1Shape.setBounds(400, 141, 80, 40);
		stateLab1Shape.setRequestResetCaption(true);
		studyingRegion1Shape.addChild(stateLab1Shape);
		
		ITransition2 tranInitialLab1Model = IModelElementFactory.instance().createTransition2();
		tranInitialLab1Model.setFrom(initialState2Model);
		tranInitialLab1Model.setTo(stateLab1Model);
		diagramManager.createConnector(diagram, tranInitialLab1Model, initialState2Shape, stateLab1Shape, null);		
		
		IState2 stateLab2Model = IModelElementFactory.instance().createState2();
		stateLab2Model.setName("Lab2");
		studyingRegion1Model.addChild(stateLab2Model);
		IState2UIModel stateLab2Shape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateLab2Model);
		stateLab2Shape.setBounds(572, 141, 80, 40);
		stateLab2Shape.setRequestResetCaption(true);
		studyingRegion1Shape.addChild(stateLab2Shape);
		
		ITransition2 tranLab1Lab2Model = IModelElementFactory.instance().createTransition2();
		tranLab1Lab2Model.setName("lab done");
		tranLab1Lab2Model.setFrom(stateLab1Model);
		tranLab1Lab2Model.setTo(stateLab2Model);
		ITransition2UIModel tranLab1Lab2Shape = (ITransition2UIModel) diagramManager.createConnector(diagram, tranLab1Lab2Model, stateLab1Shape, stateLab2Shape, new Point[]{new Point(480, 161), new Point(572, 161)});
		tranLab1Lab2Shape.setRequestResetCaption(true);

		IFinalState2 finalState1Model = IModelElementFactory.instance().createFinalState2();
		studyingRegion1Model.addChild(finalState1Model);
		IFinalState2UIModel finalState1Shape = (IFinalState2UIModel) diagramManager.createDiagramElement(diagram, finalState1Model);
		finalState1Shape.setBounds(718, 151, 20, 20);
		studyingRegion1Shape.addChild(finalState1Shape);		

		ITransition2 tranLab2FinalModel = IModelElementFactory.instance().createTransition2();
		tranLab2FinalModel.setName("lab done");
		tranLab2FinalModel.setFrom(stateLab2Model);
		tranLab2FinalModel.setTo(finalState1Model);
		ITransition2UIModel tranLab2FinalShape = (ITransition2UIModel) diagramManager.createConnector(diagram, tranLab2FinalModel, stateLab2Shape, finalState1Shape, null);		
		tranLab2FinalShape.setRequestResetCaption(true);
		
		IRegion studyingRegion2Model = stateStudyingModel.createRegion();
		IRegionUIModel studyingRegion2Shape = (IRegionUIModel) diagramManager.createDiagramElement(diagram, studyingRegion2Model);
		studyingRegion2Shape.setBounds(270, 195, 497, 79);
		stateStudyingShape.addChild(studyingRegion2Shape);

		IInitialPseudoState initialState3Model = IModelElementFactory.instance().createInitialPseudoState();
		studyingRegion2Model.addChild(initialState3Model);	
		IInitialPseudoStateUIModel initialState3Shape = (IInitialPseudoStateUIModel) diagramManager.createDiagramElement(diagram, initialState3Model);		
		initialState3Shape.setBounds(300, 226, 20, 20);
		studyingRegion2Shape.addChild(initialState3Shape);
		
		IState2 stateTeamProjectModel = IModelElementFactory.instance().createState2();
		stateTeamProjectModel.setName("Team Project");
		studyingRegion2Model.addChild(stateTeamProjectModel);
		IState2UIModel stateTeamProjectShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateTeamProjectModel);
		stateTeamProjectShape.setBounds(400, 214, 80, 40);
		stateTeamProjectShape.setRequestResetCaption(true);
		studyingRegion2Shape.addChild(stateTeamProjectShape);

		ITransition2 tranInitialTeamProjectModel = IModelElementFactory.instance().createTransition2();
		tranInitialTeamProjectModel.setFrom(initialState3Model);
		tranInitialTeamProjectModel.setTo(stateTeamProjectModel);
		diagramManager.createConnector(diagram, tranInitialTeamProjectModel, initialState3Shape, stateTeamProjectShape, null);		
				
		IFinalState2 finalState2Model = IModelElementFactory.instance().createFinalState2();
		studyingRegion2Model.addChild(finalState2Model);
		IFinalState2UIModel finalState2Shape = (IFinalState2UIModel) diagramManager.createDiagramElement(diagram, finalState2Model);
		finalState2Shape.setBounds(718, 224, 20, 20);
		studyingRegion2Shape.addChild(finalState2Shape);		

		ITransition2 tranTeamProjectFinalModel = IModelElementFactory.instance().createTransition2();
		tranTeamProjectFinalModel.setName("project done");
		tranTeamProjectFinalModel.setFrom(stateTeamProjectModel);
		tranTeamProjectFinalModel.setTo(finalState2Model);
		ITransition2UIModel tranTeamProjectFinalShape = (ITransition2UIModel) diagramManager.createConnector(diagram, tranTeamProjectFinalModel, stateTeamProjectShape, finalState2Shape, null);		
		tranTeamProjectFinalShape.setRequestResetCaption(true);
		
		IRegion studyingRegion3Model = stateStudyingModel.createRegion();
		IRegionUIModel studyingRegion3Shape = (IRegionUIModel) diagramManager.createDiagramElement(diagram, studyingRegion3Model);
		studyingRegion3Shape.setBounds(270, 274, 497, 82);
		stateStudyingShape.addChild(studyingRegion3Shape);

		IInitialPseudoState initialState4Model = IModelElementFactory.instance().createInitialPseudoState();
		studyingRegion3Model.addChild(initialState4Model);	
		IInitialPseudoStateUIModel initialState4Shape = (IInitialPseudoStateUIModel) diagramManager.createDiagramElement(diagram, initialState4Model);		
		initialState4Shape.setBounds(300, 305, 20, 20);
		studyingRegion3Shape.addChild(initialState4Shape);
		
		IState2 stateFinalTestModel = IModelElementFactory.instance().createState2();
		stateFinalTestModel.setName("Final Test");
		studyingRegion3Model.addChild(stateFinalTestModel);
		IState2UIModel stateFinalTestShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateFinalTestModel);
		stateFinalTestShape.setBounds(400, 295, 80, 40);
		stateFinalTestShape.setRequestResetCaption(true);
		studyingRegion3Shape.addChild(stateFinalTestShape);

		ITransition2 tranInitialFinalTestModel = IModelElementFactory.instance().createTransition2();		
		tranInitialFinalTestModel.setFrom(initialState4Model);
		tranInitialFinalTestModel.setTo(stateFinalTestModel);
		diagramManager.createConnector(diagram, tranInitialFinalTestModel, initialState4Shape, stateFinalTestShape, null);		
				
		IFinalState2 finalState3Model = IModelElementFactory.instance().createFinalState2();
		studyingRegion3Model.addChild(finalState3Model);
		IFinalState2UIModel finalState3Shape = (IFinalState2UIModel) diagramManager.createDiagramElement(diagram, finalState3Model);
		finalState3Shape.setBounds(718, 305, 20, 20);
		studyingRegion3Shape.addChild(finalState3Shape);		

		ITransition2 tranFinalTestFinalModel = IModelElementFactory.instance().createTransition2();	
		tranFinalTestFinalModel.setName("pass");
		tranFinalTestFinalModel.setFrom(stateFinalTestModel);
		tranFinalTestFinalModel.setTo(finalState3Model);
		ITransition2UIModel tranFinalTestFinalShape = (ITransition2UIModel) diagramManager.createConnector(diagram, tranFinalTestFinalModel, stateFinalTestShape, finalState3Shape, null);
		tranFinalTestFinalShape.setRequestResetCaption(true);
		
		IState2 stateFailedModel = IModelElementFactory.instance().createState2();
		stateFailedModel.setName("Failed");
		stateCourseAttemptRegionModel.addChild(stateFailedModel);
		IState2UIModel stateFailedShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, stateFailedModel);
		stateFailedShape.setBounds(534, 386, 80, 40);
		stateFailedShape.setRequestResetCaption(true);
		stateCourseAttemptRegionShape.addChild(stateFailedShape);

		ITransition2 tranStudyingFailedModel = IModelElementFactory.instance().createTransition2();	
		tranStudyingFailedModel.setName("failed");
		tranStudyingFailedModel.setFrom(stateFinalTestModel);
		tranStudyingFailedModel.setTo(stateFailedModel);
		ITransition2UIModel tranStudyingFailedShape = (ITransition2UIModel) diagramManager.createConnector(diagram, tranStudyingFailedModel, stateFinalTestShape, stateFailedShape, new Point[] {new Point(446, 335), new Point(446, 403), new Point(534, 403)});
		tranStudyingFailedShape.setRequestResetCaption(true);

		
		IState2 statePassedModel = IModelElementFactory.instance().createState2();
		statePassedModel.setName("Passed");
		stateCourseAttemptRegionModel.addChild(statePassedModel);
		IState2UIModel statePassedShape = (IState2UIModel) diagramManager.createDiagramElement(diagram, statePassedModel);
		statePassedShape.setBounds(677, 386, 80, 40);
		statePassedShape.setRequestResetCaption(true);
		stateCourseAttemptRegionShape.addChild(statePassedShape);
		

		ITransition2 tranStudyingPassedModel = IModelElementFactory.instance().createTransition2();	
		tranStudyingPassedModel.setFrom(stateStudyingModel);
		tranStudyingPassedModel.setTo(statePassedModel);
		diagramManager.createConnector(diagram, tranStudyingPassedModel, stateStudyingShape, statePassedShape, null);
		
		// show up the diagram		
		diagramManager.openDiagram(diagram);				
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
