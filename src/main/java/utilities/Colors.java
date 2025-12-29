package utilities;
import java.util.Map;

public class Colors {

    private static Map<String, String> colors = Map.ofEntries(

            //Botón principal
            Map.entry("principal-button-background-dm", "#4DC0D4FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-border-dm", "#4DC0D4FF"), //COLOR DE BORDE DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-font-color-dm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-background-hover-dm", "#49AEC0FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL CUANDO HACE HOVER
            Map.entry("principal-button-border-hover-dm", "#49AEC0FF"), //COLOR DE BORDE DEL BOTÓN PRINCIPAL CUANDO HACE HOVER

            Map.entry("principal-button-font-color-hover-dm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL CUANDO HACE HOVER
            Map.entry("principal-button-background-lm", "#192D91FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-border-lm", "#192D91FF"), //COLOR DE BORDE DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-font-color-lm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL
            Map.entry("principal-button-background-hover-lm", "#475DC9FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL CUANDO HACE HOVER
            Map.entry("principal-button-border-hover-lm", "#475DC9FF"), //COLOR DE BORDE DEL BOTÓN PRINCIPAL CUANDO HACE HOVER
            Map.entry("principal-button-font-color-hover-lm", "#F5F5F5FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL CUANDO HACE HOVER

            //Botón secundario
            Map.entry("secondary-button-background-lm", "#FFFFFFFF"), //COLOR DE FONDO DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-border-lm", "#D1D5E9FF"), //COLOR DE BORDE DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-font-color-lm", "#535355FF"), //COLOR DE FUENTE DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-background-hover-lm", "#E8E9F4FF"), //COLOR DE FONDO DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER
            Map.entry("secondary-button-border-hover-lm", "#C1C6E1FF"), //COLOR DE BORDE DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER
            Map.entry("secondary-button-font-color-hover-lm", "#192D91FF"), //COLOR DE FUENTE DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER

            Map.entry("secondary-button-background-dm", "#2E333DFF"), //COLOR DE FONDO DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-border-dm", "#3C4454FF"), //COLOR DE BORDE DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-font-color-dm", "#FFFFFFFF"), //COLOR DE FUENTE DEL BOTÓN SECUNDARIO
            Map.entry("secondary-button-background-hover-dm", "#323844FF"), //COLOR DE FONDO DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER
            Map.entry("secondary-button-border-hover-dm", "#3B4353FF"), //COLOR DE BORDE DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER
            Map.entry("secondary-button-font-color-hover-dm", "#4DC0D4FF"), //COLOR DE FUENTE DEL BOTÓN SECUNDARIO CUANDO EL USUARIO HACE HOVER

            //Botón desactivado
            Map.entry("button-background-disabled-dm", "#2F2F2FFF"), //COLOR DE FONDO DE LOS BOTONES DESACTIVADOS
            Map.entry("button-border-disabled-dm", "#2F2F2FFF"), //COLOR DE BORDE DE LOS BOTONES DESACTIVADOS
            Map.entry("button-font-color-disabled-dm", "#9A9A9AFF"), //COLOR DE LA FUENTE DE LOS BOTONES DESACTIVADOS

            Map.entry("button-background-disabled-lm", "#E0E0E0FF"), //COLOR DE FONDO DE LOS BOTONES DESACTIVADOS
            Map.entry("button-border-disabled-lm", "#E0E0E0FF"), //COLOR DE BORDE DE LOS BOTONES DESACTIVADOS
            Map.entry("button-font-color-disabled-lm", "#9A9A9AFF"), //COLOR DE LA FUENTE DE LOS BOTONES DESACTIVADOS

            //Botón oculto
            Map.entry("hide-button-background-lm", "#F5F5F5FF"), //COLOR DE FONDO DEL BOTÓN OCULTO
            Map.entry("hide-button-border-lm", "#F5F5F5FF"), //COLOR DEL BORDE DEL BOTÓN OCULTO
            Map.entry("hide-button-font-color-lm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN OCULTO
            Map.entry("hide-button-background-hover-lm", "#E8E9F4FF"), //COLOR DE FONDO DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER
            Map.entry("hide-button-border-hover-lm", "#E8E9F4FF"), //COLOR DEL BORDE DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER
            Map.entry("hide-button-font-color-hover-lm", "#192D91FF"), //COLOR DE LA FUENTE DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER

            Map.entry("hide-button-background-dm", "#282C34FF"), //COLOR DE FONDO DEL BOTÓN OCULTO
            Map.entry("hide-button-border-dm", "#282C34FF"), //COLOR DEL BORDE DEL BOTÓN OCULTO
            Map.entry("hide-button-font-color-dm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN OCULTO
            Map.entry("hide-button-background-hover-dm", "#323844FF"), //COLOR DE FONDO DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER
            Map.entry("hide-button-border-hover-dm", "#323844FF"), //COLOR DEL BORDE DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER
            Map.entry("hide-button-font-color-hover-dm", "#4DC0D4FF"), //COLOR DE LA FUENTE DEL BOTÓN OCULTO CUANDO EL USUARIO HACE HOVER

            //Tarjetas
            Map.entry("card-background-dm", "#2E333DFF"), //COLOR DE FONDO DE LAS TARJETAS
            Map.entry("card-border-color-dm", "#4DC0D4FF"), //COLOR DEL BORDE DE LAS TARJETAS

            Map.entry("card-background-lm", "#EDEDEDFF"), //COLOR DE FONDO DE LAS TARJETAS
            Map.entry("card-border-color-lm", "#192D91FF"), //COLOR DE BORDE DE LAS TARJETAS

            //Barra de título
            //Sin focus
            Map.entry("title-bar-background-without-focus-dm", "#282C34FF"), //COLOR DE FONDO DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-border-without-focus-dm", "#3C4454FF"), //COLOR DEL BORDE DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-font-color-whithout-focus-dm", "#D5D5D5FF"), //COLOR DE LA FUENTE DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con Focus
            Map.entry("title-bar-background-with-focus-dm", "#4DC0D4FF"), //COLOR DE FONDO DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-border-with-focus-dm", "#4DC0D4FF"), //COLOR DEL BORDE DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-font-color-whith-focus-dm", "#121212FF"), //COLOR DE LA FUENTE DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Botón principal
            //Sin focus
            Map.entry("title-bar-button-background-without-focus-dm", "#282C34FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-border-without-focus-dm", "#282C34FF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-font-color-without-focus-dm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con focus
            Map.entry("title-bar-button-background-with-focus-dm", "#4DC0D4FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-border-with-focus-dm", "#4DC0D4FF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-font-color-with-focus-dm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Con hover
            Map.entry("title-bar-button-background-with-focus-hover-dm", "#71CDDDFF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-button-border-with-focus-hover-dm", "#71CDDDFF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-button-font-color-with-focus-hover-dm", "#000000FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN

            //Botón de cerrar
            //Sin focus
            Map.entry("title-bar-close-button-background-without-focus-dm", "#282C34FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-border-without-focus-dm", "#282C34FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-font-color-without-focus-dm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con focus
            Map.entry("title-bar-close-button-background-with-focus-dm", "#4DC0D4FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-border-with-focus-dm", "#4DC0D4FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-font-color-with-focus-dm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Con hover
            Map.entry("title-bar-close-button-background-with-focus-hover-dm", "#DC3545FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-close-button-border-with-focus-hover-dm", "#DC3545FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-close-button-font-color-with-focus-hover-dm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN

            //Barra de título
            //Sin focus
            Map.entry("title-bar-background-without-focus-lm", "#F5F5F5FF"), //COLOR DE FONDO DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-border-without-focus-lm", "#D1D5E9FF"), //COLOR DEL BORDE DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-font-color-whithout-focus-lm", "#121212FF"), //COLOR DE LA FUENTE DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con focus
            Map.entry("title-bar-background-with-focus-lm", "#192D91FF"), //COLOR DE FONDO DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-border-with-focus-lm", "#192D91FF"), //COLOR DEL BORDE DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-font-color-whith-focus-lm", "#D5D5D5FF"), //COLOR DE LA FUENTE DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Botón principal
            //Sin focus
            Map.entry("title-bar-button-background-without-focus-lm", "#F5F5F5FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-border-without-focus-lm", "#F5F5F5FF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-font-color-without-focus-lm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con focus
            Map.entry("title-bar-button-background-with-focus-lm", "#192D91FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-border-with-focus-lm", "#192D91FF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-button-font-color-with-focus-lm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Con hover
            Map.entry("title-bar-button-background-with-focus-hover-lm", "#4757A7FF"), //COLOR DE FONDO DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-button-border-with-focus-hover-lm", "#4757A7FF"), //COLOR DEL BORDE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-button-font-color-with-focus-hover-lm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN PRINCIPAL DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN

            //Botón de cerrar
            //Sin focus
            Map.entry("title-bar-close-button-background-without-focus-lm", "#F5F5F5FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-border-without-focus-lm", "#F5F5F5FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-font-color-without-focus-lm", "#121212FF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR NO ESTÁ SOBRE LA BARRA

            //Con focus
            Map.entry("title-bar-close-button-background-with-focus-lm", "#192D91FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-border-with-focus-lm", "#192D91FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA
            Map.entry("title-bar-close-button-font-color-with-focus-lm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA

            //Con hover
            Map.entry("title-bar-close-button-background-with-focus-hover-lm", "#DC3545FF"), //COLOR DE FONDO DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-close-button-border-with-focus-hover-lm", "#DC3545FF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN
            Map.entry("title-bar-close-button-font-color-with-focus-hover-lm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR DE LA BARRA DE TÍTULO CUANDO EL CURSOR ESTÁ SOBRE LA BARRA Y EL BOTÓN

            //Tooltip
            Map.entry("tooltip-background-lm", "#2E333DFF"), //COLOR DE FONDO DEL TOOLTIP
            Map.entry("tooltip-border-lm", "#3C4454FF"), //COLOR DEL BORDE DEL TOOLTIP
            Map.entry("tooltip-font-color-lm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL TOOLTIP

            Map.entry("tooltip-background-dm", "#FFFFFFFF"), //COLOR DE FONDO DEL TOOLTIP
            Map.entry("tooltip-border-dm", "#D1D5E9FF"), //COLOR DEL BORDE DEL TOOLTIP
            Map.entry("tooltip-font-color-dm", "#535355FF"), //COLOR DE LA FUENTE DEL TOOLTIP

            //Cuerpo
            Map.entry("title-font-color-lm", "#192D91FF"), //COLOR DEL TÍTULO
            Map.entry("title-font-color-dm", "#4DC0D4FF"), //COLOR DEL TÍTULO

            Map.entry("content-font-color-dm", "#D5D5D5FF"), //COLOR DEL CONTENIDO
            Map.entry("content-font-color-lm", "#121212FF"), //COLOR DEL CONTENIDO

            //Error
            Map.entry("error", "#1818FFFF") //COLOR QUE APARECERÁ CUANDO NO SE ENCUENTRE UNA VARIABLE

    );

    /**
     * Retorna el color de la clave que tenga el Map `colors`.
     *
     * @param key clave base (sin sufijo) o clave ya con sufijo "-lm"/"-dm"
     * @param isDarkMode True = modo oscuro, False = modo claro
     * @return valor de colors para la clave ajustada, o colors.get("error") si no existe
     */
    public static String getColor(String key, boolean isDarkMode) {
        if (key == null || key.trim().isBlank()) {
            return colors.get("error");
        }

        key = key.trim().toLowerCase();

        final String SUFFIX_DARK = "-dm";
        final String SUFFIX_LIGHT = "-lm";
        final String desiredSuffix = isDarkMode ? SUFFIX_DARK : SUFFIX_LIGHT;
        final int SUFFIX_LEN = desiredSuffix.length(); // 3

        if (key.endsWith(SUFFIX_DARK) || key.endsWith(SUFFIX_LIGHT)) {
            if (!key.endsWith(desiredSuffix)) {

                key = key.substring(0, key.length() - SUFFIX_LEN) + desiredSuffix;
            }
        } else {

            key = key + desiredSuffix;
        }

        return colors.getOrDefault(key, colors.get("error"));
    }


}