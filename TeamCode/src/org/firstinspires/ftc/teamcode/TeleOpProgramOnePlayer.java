package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="<COMPETITION> TeleOpProgramOnePlayer", group = "MecanumBot")
public class TeleOpProgramOnePlayer extends LinearOpMode {

    Robot robot = new Robot();   // Use a Pushbot's hardware

    @Override
    public void runOpMode() {
        boolean directionToggle = true;
        boolean motorToggle = true;
        boolean inputDirectionToggle = true;
        boolean shooterPowerToggle = true;
        double motorCoefficient = 1.0;


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("10130 Let's Go!", "");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //Driving
            //if (gamepad1.left_stick_y > .2f || gamepad1.left_stick_x > .2f || gamepad2.right_stick_x > .2f || gamepad2.left_stick_y > .2f) {
            double motorCoeff = 1.2;
            double magnitude = Math.hypot(gamepad1.left_stick_x, -gamepad1.left_stick_y);
            double robotAngle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            double fld = (magnitude * Math.cos(robotAngle) + rightX) * motorCoeff; //cos +
            double frd = (magnitude * Math.sin(robotAngle) - rightX) * motorCoeff; //sin -
            double bld = (magnitude * Math.sin(robotAngle) + rightX) * motorCoeff; //sin
            double brd = (magnitude * Math.cos(robotAngle) - rightX) * motorCoeff; //cos

            if (gamepad1.right_bumper) {
                fld = fld * 0.4;
                frd = frd * 0.4;
                bld = bld * 0.4;
                brd = brd * 0.4;
            }

            robot.leftFront.setPower(fld);
            robot.rightFront.setPower(frd);
            robot.leftBack.setPower(bld);
            robot.rightBack.setPower(brd);


            telemetry.addData("leftFront", "%.2f", -fld);
            telemetry.addData("rightFront", "%.2f", -frd);
            telemetry.addData("leftBack", "%.2f", -bld);
            telemetry.addData("rightBack", "%2f", -brd);


            //gamepad2 controls

            //int reverseDirection = 1;

            if(gamepad1.a) {
                //robot.lift.setPower(.85);
                sleep(10);
                //robot.lift.setPower((0.0));
                //telemetry.addData("liftPosition", robot.lift.getCurrentPosition());
                telemetry.update();

            }
            if (gamepad1.y) {
                //robot.lift.setPower(-.85);
                sleep(10);
                //robot.lift.setPower(0.0);
                //telemetry.addData("liftPosition", robot.lift.getCurrentPosition());
                telemetry.update();
            }

            if(gamepad1.b)
            {
                //robot.claw.setPosition(0.49);
            }

            if(gamepad1.x)
            {
                //robot.claw.setPosition(0.15);
            }



            //robot.spinner.setPower(gamepad1.left_trigger * .1 * reverseDirection);


            //robot.lift.setPower(gamepad1.right_stick_y);

            /*if (gamepad1.dpad_up)
                robot.intake.setPower(.05);
            if (gamepad1.dpad_down)
                robot.intake.setPower(-.07);*/

        }
    }
}