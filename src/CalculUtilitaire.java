public class CalculUtilitaire {
    public static short calculEnergieAutreMG(float energie){
        if (energie <= 335 ){
            return 0;
        } else if (energie <= 670) {
            return 1;
        } else if (energie <= 1005) {
            return 2;
        } else if (energie <= 1340) {
            return 3;
        } else if (energie <= 1675) {
            return 4;
        } else if (energie <= 2010) {
            return 5;
        } else if (energie <= 2345) {
            return 6;
        } else if (energie <= 2680) {
            return 7;
        } else if (energie <= 3015) {
            return 8;
        } else if (energie <= 3350) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short calculSucresSimplesAutresMG(float sucresSimples){
        if (sucresSimples <= 4.5f){
            return 0;
        } else if (sucresSimples <= 9) {
            return 1;
        } else if (sucresSimples <= 13.5f) {
            return 2;
        } else if (sucresSimples <= 18) {
            return 3;
        } else if (sucresSimples <= 22.5f) {
            return 4;
        } else if (sucresSimples <= 27) {
            return 5;
        } else if (sucresSimples <= 31) {
            return 6;
        } else if (sucresSimples <= 36) {
            return 7;
        } else if (sucresSimples <= 40) {
            return 8;
        } else if (sucresSimples <= 45) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short acideGrasSaturesAutresBoisson(float acideGras){
        if (acideGras <= 1){
            return 0;
        } else if (acideGras <= 2) {
            return 1;
        } else if (acideGras <= 3) {
            return 2;
        } else if (acideGras <= 4) {
            return 3;
        } else if (acideGras <= 5) {
            return 4;
        } else if (acideGras <= 6) {
            return 5;
        } else if (acideGras <= 7) {
            return 6;
        } else if (acideGras <= 8) {
            return 7;
        } else if (acideGras <= 89) {
            return 8;
        } else if (acideGras <= 10) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short acideGrasSaturesMG(float acideGras){
        if (acideGras <= 90){
            return 0;
        } else if (acideGras <= 180) {
            return 1;
        } else if (acideGras <= 270) {
            return 2;
        } else if (acideGras <= 360) {
            return 3;
        } else if (acideGras <= 450) {
            return 4;
        } else if (acideGras <= 540) {
            return 5;
        } else if (acideGras <= 630) {
            return 6;
        } else if (acideGras <= 720) {
            return 7;
        } else if (acideGras <= 810) {
            return 8;
        } else if (acideGras <= 900) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short sodium(float sodium){
        if (sodium <= 90){
            return 0;
        } else if (sodium <= 180) {
            return 1;
        } else if (sodium <= 270) {
            return 2;
        } else if (sodium <= 360) {
            return 3;
        } else if (sodium <= 450) {
            return 4;
        } else if (sodium <= 540) {
            return 5;
        } else if (sodium <= 630) {
            return 6;
        } else if (sodium <= 720) {
            return 7;
        } else if (sodium <= 810) {
            return 8;
        } else if (sodium <= 900) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short calculEnergieBoisson(float energie){
        if (energie <= 0){
            return 0;
        } else if (energie <= 30) {
            return 1;
        } else if (energie <= 60) {
            return 2;
        } else if (energie <= 90) {
            return 3;
        } else if (energie <= 120) {
            return 4;
        } else if (energie <= 150) {
            return 5;
        } else if (energie <= 180) {
            return 6;
        } else if (energie <= 210) {
            return 7;
        } else if (energie <= 240) {
            return 8;
        } else if (energie <= 270) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short calculSucresSimplesBoisson(float sucresSimples){
        if (sucresSimples <= 0.0f){
            return 0;
        } else if (sucresSimples <= 1.5f) {
            return 1;
        } else if (sucresSimples <= 3.0f) {
            return 2;
        } else if (sucresSimples <= 4.5f) {
            return 3;
        } else if (sucresSimples <= 6.0f) {
            return 4;
        } else if (sucresSimples <= 7.5f) {
            return 5;
        } else if (sucresSimples <= 9.0f) {
            return 6;
        } else if (sucresSimples <= 10.5f) {
            return 7;
        } else if (sucresSimples <= 12.0f) {
            return 8;
        } else if (sucresSimples <= 13.5f) {
            return 9;
        }else {
            return 10;
        }
    }
    public static short calculFruit_leg(float fruit_leg){
        if (fruit_leg <= 40.0f){
            return 0;
        } else if (fruit_leg <= 60.0f) {
            return 1;
        } else if (fruit_leg <= 80.0f) {
            return 2;
        }else {
            return 5;
        }
    }
    public static short calculFruit_leg_boisson(float fruit_leg){
        if (fruit_leg <= 40.0f){
            return 0;
        } else if (fruit_leg <= 60.0f) {
            return 2;
        }else if (fruit_leg <= 80.0f){
            return 4;
        }else{
            return 10;
        }
    }
    public static short calculFibres(float val_fibres){
        if (val_fibres <= 0.7f){
            return 0;
        }else if(val_fibres <= 1.4f){
            return 1;
        } else if (val_fibres <= 2.1f) {
            return 2;
        } else if (val_fibres <= 2.8f) {
            return 3;
        } else if (val_fibres <= 3.5f){
            return 4;
        }else{
            return 5;
        }
    }
    public static short calculProteines(float proteines){
        if (proteines <= 1.6f){
            return 0;
        } else if (proteines <= 3.2f) {
            return 1;
        } else if (proteines <= 4.8f) {
            return 2;
        } else if (proteines <= 6.4f) {
            return 3;
        } else if (proteines <= 8.0f) {
            return 4;
        }else {
            return 5;
        }
    }
}