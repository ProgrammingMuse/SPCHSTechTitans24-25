package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.functions.OmniDrive;

@TeleOp(name="AlinaMain", group="Linear OpMode")
public class AlinaMain extends LinearOpMode {

    //these variables are so real just in case
    public ElapsedTime runtime = new ElapsedTime();

    public DcMotor leftFrontDrive;
    public DcMotor leftBackDrive;
    public DcMotor rightFrontDrive;
    public DcMotor rightBackDrive;
    public DcMotor armMotor;
    public TouchSensor slideSafety;
    private final SlideFunctions epicSliders = new SlideFunctions();

    @Override
    public void runOpMode() {

        // Initialize hardware and omniDriveHelper
        OmniDrive OmniFunction = new OmniDrive(hardwareMap);
        DcMotor slideMotor = hardwareMap.get(DcMotor.class, "slide_motor");
        armMotor = hardwareMap.get(DcMotor.class, "arm_motor");
        slideSafety = hardwareMap.get(TouchSensor.class, "slide_safety");

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Initialized","Status");
        telemetry.update();
        waitForStart();
        runtime.reset();


        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call the omniFunction method and pass in the gamepad and telemetry
            OmniFunction.OmniUpdate(gamepad1,telemetry);
            epicSliders.ArmPosition(gamepad1, gamepad2, slideMotor, slideSafety, telemetry);
            epicSliders.SlidePosition(gamepad1, gamepad2, armMotor, telemetry);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
