package logical;

import connections.Users;
import messagebuilder.MessageBuilder;
import stylebuilder.StyleBuilder;
import user.UserData;

public class ValidateFormInputs {

    public static void validateInputsFromLogin(String email, String password){

        boolean [] aspects = new boolean[3];

        Users users = new Users();

        email = StyleBuilder.clearStringFormat(email);

        aspects[0] = ValidateInputs.haveAnyWord(email);
        aspects[1] = ValidateInputs.haveAnyWord(password);
        aspects[2] = aspects[1] && aspects[0] ? users.getUserIDWithEmailAndPassword(email, ValidateOutputs.sha256Hex(password)) : true;

        if(isAllBooleanArrayTrue(aspects)){

            //Todo salió bien
            users.loginWithUserID();

            MessageBuilder.showConfirmMessageFromLogin();

        }else{

            //Algo fallo
            MessageBuilder.showErrorMessageFromLogin(aspects);

        }

    }

    public static void validateInputsFromGuest(String name, String lastname, String nickname, UserData.Sex sex, String birthday){

        boolean [] aspects = new boolean[5];

        name = StyleBuilder.clearStringFormat(name);
        lastname = StyleBuilder.clearStringFormat(lastname);
        nickname = StyleBuilder.clearStringFormat(nickname);

        aspects[0] = ValidateInputs.haveAnyWord(name);
        aspects[1] = ValidateInputs.haveAnyWord(lastname);
        aspects[2] = nickname == null || ValidateInputs.haveAnyWord(nickname);
        aspects[3] = sex != null;
        aspects[4] = ValidateInputs.isValidBirthday(birthday);


        if(isAllBooleanArrayTrue(aspects)){

            //El usuario ingresó todo correctamente
            MessageBuilder.showConfirmMessageFromGuest(new String [] {name, lastname, nickname, sex == UserData.Sex.MAN ? "Hombre" : "Mujer", birthday});

        }else{

            //El usuario no ingresó todo correctamente
            MessageBuilder.showErrorMessageFromGuest(aspects);

        }

    }

    public static void validateInputsFromSignUp(String name, String lastname, String nickname, String email, String password, String confirmPassword, UserData.Sex sex, String birthday){

        Users user = new Users();

        boolean [] aspects = new boolean[14];

        name = StyleBuilder.clearStringFormat(name);
        lastname = StyleBuilder.clearStringFormat(lastname);
        nickname = StyleBuilder.clearStringFormat(nickname);

        aspects [0] = ValidateInputs.haveAnyWord(name);
        aspects [1] = ValidateInputs.validateStringLength(name, 50);
        aspects [2] = ValidateInputs.haveAnyWord(lastname);
        aspects [3] = ValidateInputs.validateStringLength(lastname, 50);
        aspects [4] = nickname == null ? true : ValidateInputs.haveAnyWord(nickname);
        aspects [5] = aspects [4] && nickname != null ? ValidateInputs.validateStringLength(nickname, 50) : true;
        aspects [6] = ValidateInputs.haveAnyWord(email);
        aspects [7] = aspects [6] ? ValidateInputs.validateStringLength(email, 255) : true;
        aspects [8] = aspects [6] && aspects[7] ? user.isUniqueEmail(email) : true;//Corroborar que sea único el email
        aspects [9] = ValidateInputs.haveAnyWord(password);
        aspects [10] = ValidateInputs.haveAnyWord(confirmPassword);
        aspects [11] = password.equals(confirmPassword);
        aspects [12] = sex != null;
        aspects [13] = ValidateInputs.isValidBirthday(birthday);//Validar fecha de nacimiento

        if(isAllBooleanArrayTrue(aspects)){

            //Todo salió correcto
            MessageBuilder.showConfirmMessageFromSignUp(new String [] {

                    name,
                    lastname,
                    nickname,
                    email,
                    password,
                    sex == UserData.Sex.MAN ? "hombre" : "mujer",
                    birthday

            });

        }else{

            //Hay un dato o más incorrecto

            MessageBuilder.showErrorMessageFromSignUp(aspects, new String [] {name, lastname});

        }

    }

    private static boolean isAllBooleanArrayTrue(boolean[] array) {

        if(array == null) return false;

        boolean result = true;

        for (int i = 0; i < array.length; i++) {

            if (!array[i]) {

                result = false;
                System.out.println("El aspecto " + i + " es inválido");

            }

        }

        return result;

    }

}
