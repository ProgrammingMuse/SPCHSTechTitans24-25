package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
public class SlideControls{

    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor slideMotor = null;
    public DcMotor armMotor = null;
    public TouchSensor slideSafety = null;

    //DriveTrain Motors
    // Initialize the hardware variables. Note that the strings used here must correspond
    // to the names assigned during the robot configuration step on the DS or RC devices.
    // Motors
    public SlideControls(HardwareMap hardwareMap){
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        armMotor = hardwareMap.get(DcMotor.class, "arm_motor");
        slideSafety = hardwareMap.get(TouchSensor.class, "slide_safety");
    }
    public void init( HardwareMap hardwareMap){
        slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        armMotor = hardwareMap.get(DcMotor.class, "arm_motor");
        slideSafety = hardwareMap.get(TouchSensor.class, "slide_safety");
    }

    public void setSlideMotor(DcMotor slideMotor) {
        this.slideMotor = slideMotor;
        slideMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setArmMotor(DcMotor armMotor) {
        this.armMotor = armMotor;
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }



    SlideFunctions slide = new SlideFunctions();

}
