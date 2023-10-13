package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;

public class Robot {
    //Control Hub Assignments
    //C: Control hub
    //E: Expansion hub

    /* Public OpMode members. */
    public DcMotor leftFront   = null; //C0
    public DcMotor  rightFront  = null; //C1
    public DcMotor leftBack   = null; //C2
    public DcMotor  rightBack  = null; //C3


    //public DcMotor lift = null;

    //public DcMotor spinner = null;
    //public Servo claw = null;
    //public CRServo intake = null;

    /* local OpMode members. */
    HardwareMap hwMap  =  null;
    public ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Robot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        //cameraMonitorViewId = hwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.getPackageName());

        // Define and Initialize Motors
        leftFront  = hwMap.get(DcMotor.class, "front_left_motor");
        rightFront = hwMap.get(DcMotor.class, "front_right_motor");
        leftBack  = hwMap.get(DcMotor.class, "back_left_motor");
        rightBack = hwMap.get(DcMotor.class, "back_right_motor");

        //lift = hwMap.get(DcMotor.class, "lift");

        //spinner =  hwMap.get(DcMotor.class, "spinner");
        //claw =  hwMap.get(Servo.class, "claw");
        //intake =  hwMap.get(CRServo.class, "intake");

        //imu = hwMap.get(BNO055IMU.class, "imu");
        leftFront.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightFront.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        leftBack.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        rightBack.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors


        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        // Set all motors to zero power

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        //claw.setPosition(0.49);
        //claw.scaleRange(0.15, 0.69);


        //spinner.setPower(0);
        //lift.setPower(0);

        //grabber.setPosition(MID_SERVO);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //0
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //3
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //1
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //2


        //spinner.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //expansion hub 0
        //lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}