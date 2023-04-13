package com.common.utils;

import com.qmetry.qaf.automation.step.QAFTestStepAdapter;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.util.Reporter;

    public class TestStepListener extends QAFTestStepAdapter {

    @Override
    public void beforExecute(StepExecutionTracker stepExecutionTracker) {
        System.out.println("--------------------TestListener beforExecute---------------------"+stepExecutionTracker.getStep().getName());
    }

    @Override
    public void afterExecute(StepExecutionTracker stepExecutionTracker) {
        System.out.println("--------------------TestListener afterExecute---------------------"+stepExecutionTracker.getStep().getName());
    }

}
