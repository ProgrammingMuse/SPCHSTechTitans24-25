package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "AlinaMain")
public class AlinaMain extends LinearOpMode {

    private ElapsedTime runtime;
    public AlinaMain() {
        runtime = new ElapsedTime();
    }

    @Override
    public void runOpMode() {
        // Initialize hardware and omniDriveHelper
        OmniDrive OmniFunction = new OmniDrive(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Initialized","Status");
        telemetry.update();
        waitForStart();
        runtime.reset();
        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Call the omniFunction method and pass in the gamepad and telemetry
            OmniFunction.OmniUpdate(gamepad1,telemetry);
        }
    }
}
