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

            //Fases de verificación del email
            //Primera fase
            Map.entry("email-not-verified-first-fase-font-color-lm", "#192D91FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE
            Map.entry("email-not-verified-first-fase-background-lm", "#192D9133"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE
            Map.entry("email-not-verified-first-fase-border-lm", "#192D91FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE

            //Segunda fase
            Map.entry("email-not-verified-second-fase-background-lm", "#F9862633"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE
            Map.entry("email-not-verified-second-fase-border-lm", "#F98626FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE
            Map.entry("email-not-verified-second-fase-font-color-lm", "#F98626FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE

            //Tercera fase
            Map.entry("email-not-verified-third-fase-background-lm", "#E2423733"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE
            Map.entry("email-not-verified-third-fase-border-lm", "#E24237FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE
            Map.entry("email-not-verified-third-fase-font-color-lm", "#E24237FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE

            //Primera fase
            Map.entry("email-not-verified-first-fase-font-color-dm", "#4DC0D4FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE
            Map.entry("email-not-verified-first-fase-background-dm", "#4DC0D433"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE
            Map.entry("email-not-verified-first-fase-border-dm", "#4DC0D4FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU PRIMERA FASE

            //Segunda fase
            Map.entry("email-not-verified-second-fase-background-dm", "#F9862633"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE
            Map.entry("email-not-verified-second-fase-border-dm", "#F98626FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE
            Map.entry("email-not-verified-second-fase-font-color-dm", "#F98626FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU SEGUNDA FASE

            //Tercera fase
            Map.entry("email-not-verified-third-fase-background-dm", "#E2423733"), //COLOR DEL FONDO DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE
            Map.entry("email-not-verified-third-fase-border-dm", "#E24237FF"), //COLOR DEL BORDE DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE
            Map.entry("email-not-verified-third-fase-font-color-dm","#E24237FF"), //COLOR DE LA LETRA DEL CONTENEDOR DEL EMAIL NO VERIFICADO EN SU TERCERA FASE

            //Toast Notification
            Map.entry("toast-notification-background-lm", "#F5F5F5FF"), //COLOR DEL FONDO DEL TOAST NOTIFICATION
            Map.entry("toast-notification-border-lm", "#192D91FF"), //COLOR DEL BORDE DEL TOAST NOTIFICATION
            Map.entry("toast-notification-font-color-lm", "#121212FF"), //COLOR DE LA FUENTE DEL TOAST NOTIFICATION

            Map.entry("toast-notification-background-dm", "#282C34FF"), //COLOR DEL FONDO DEL TOAST NOTIFICATION
            Map.entry("toast-notification-border-dm", "#4DC0D4"), //COLOR DEL BORDE DEL TOAST NOTIFICATION
            Map.entry("toast-notification-font-color-dm", "#D5D5D5FF"), //COLOR DE LA FUENTE DEL TOAST NOTIFICATION

            //Tarjetas de Popup
            Map.entry("popup-card-background-lm", "#FFFFFFFF"), //COLOR DEL FONDO DE LA TARJETA EN POPUP
            Map.entry("popup-card-border-lm", "#E8EAF4FF"), //COLOR DEL BORDE DE LA TARJETA EN POPUP
            Map.entry("popup-card-background-hover-lm", "#F3F4F9FF"), //COLOR DEL FONDO DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-border-hover-lm", "#B1B8D9FF"), //COLOR DEL BORDE DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER

            Map.entry("popup-card-background-dm", "#2E3442FF"), //COLOR DEL FONDO DE LA TARJETA EN POPUP
            Map.entry("popup-card-border-dm", "#35505FFF"), //COLOR DEL BORDE DE LA TARJETA EN POPUP
            Map.entry("popup-card-background-hover-dm", "#2F3542FF"), //COLOR DEL FONDO DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-border-hover-dm", "#3C6C7DFF"), //COLOR DEL BORDE DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER

            //Botón de tarjetas de Popup
            Map.entry("popup-card-button-background-lm", "#F3F4F9FF"), //COLOR DEL FONDO DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-border-lm", "#F3F4F9FF"), //COLOR DEL BORDE DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-font-color-lm", "#29292AFF"), //COLOR DE LA FUENTE DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-background-hover-lm", "#DDDFEFFF"), //COLOR DEL FONDO DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-button-border-hover-lm", "#DDDFEFFF"), //COLOR DEL BORDE DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-button-font-color-hover-lm", "#293C98FF"), //COLOR DE LA FUENTE DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER

            Map.entry("popup-card-button-background-dm", "#2F3542FF"), //COLOR DEL FONDO DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-border-dm", "#2F3542FF"), //COLOR DEL BORDE DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-font-color-dm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN DE LA TARJETA EN POPUP
            Map.entry("popup-card-button-background-hover-dm", "#353C4BFF"), //COLOR DEL FONDO DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-button-border-hover-dm", "#353C4BFF"), //COLOR DEL BORDE DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-card-button-font-color-hover-dm", "#4AB0C4FF"), //COLOR DE LA FUENTE DEL BOTÓN DE LA TARJETA EN POPUP CUANDO EL USUARIO HACE HOVER

            //Botón terciario del popup
            Map.entry("popup-third-button-background-lm", "#FFFFFFFF"), //COLOR DEL FONDO DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-border-lm", "#FF7210FF"), //COLOR DEL BORDE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-font-color-lm", "#FF7210FF"), //COLOR DE LA FUENTE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-background-hover-lm", "#FFF0E6FF"), //COLOR DEL FONDO DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-border-hover-lm", "#FF7210FF"), //COLOR DEL BORDE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-font-color-hover-lm", "#FF7210FF"), //COLOR DE LA FUENTE DEL BOTÓN TERCIARIO DEL POPUP

            Map.entry("popup-third-button-background-dm", "#333947FF"), //COLOR DEL FONDO DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-border-dm", "#3C4454FF"), //COLOR DEL BORDE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-font-color-dm", "#FF7210FF"), //COLOR DE LA FUENTE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-background-hover-dm", "#353C4BFF"), //COLOR DEL FONDO DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-border-hover-dm", "#3A4252FF"), //COLOR DEL BORDE DEL BOTÓN TERCIARIO DEL POPUP
            Map.entry("popup-third-button-font-color-hover-dm", "#FF7210FF"), //COLOR DE LA FUENTE DEL BOTÓN TERCIARIO DEL POPUP

            //Botón para cerrar el popup en la barra de título
            Map.entry("popup-title-bar-close-button-background-lm", "#F5F5F5FE"), //COLOR DEL FONDO DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-border-lm", "#F5F5F5FE"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-font-color-lm", "#535355FF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-background-hover-lm", "#FAE9ECFF"), //COLOR DEL FONDO DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-title-bar-close-button-border-hover-lm", "#FAE9ECFF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-title-bar-close-button-font-color-hover-lm", "#DD3D4CFF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER

            Map.entry("popup-title-bar-close-button-background-dm", "#282C34FE"), //COLOR DEL FONDO DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-border-dm", "#282C34FE"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-font-color-dm", "#FFFFFFFF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP
            Map.entry("popup-title-bar-close-button-background-hover-dm", "#353D4CFF"), //COLOR DEL FONDO DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-title-bar-close-button-border-hover-dm", "#353D4CFF"), //COLOR DEL BORDE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-title-bar-close-button-font-color-hover-dm", "#DF4B3CFF"), //COLOR DE LA FUENTE DEL BOTÓN PARA CERRAR EN LA BARRA DE TÍTULO EN UN POPUP CUANDO EL USUARIO HACE HOVER

            //Popup ToggleButton
            Map.entry("popup-toggle-button-background-lm", "#FFFFFFFF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-border-lm", "#D1D5E9FF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-font-color-lm", "#232323FF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-background-hover-lm", "#F3F4F9FF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-toggle-button-border-hover-lm", "#B1B8D9FF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-toggle-button-font-color-hover-lm", "#1E1E1EFF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER

            Map.entry("popup-toggle-button-background-dm", "#2E3442FF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-border-dm", "#375E6EFF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-font-color-dm", "#EBECEDFF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP
            Map.entry("popup-toggle-button-background-hover-dm", "#2F3542FF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-toggle-button-border-hover-dm", "#3E7A8AFF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER
            Map.entry("popup-toggle-button-font-color-hover-dm", "#F7F7F7FF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP CUANDO EL USUARIO HACE HOVER

            Map.entry("popup-toggle-button-background-active-lm", "#E8E9F4FF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO
            Map.entry("popup-toggle-button-border-active-lm", "#192D91FF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO
            Map.entry("popup-toggle-button-font-color-active-lm", "#223494FF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO

            Map.entry("popup-toggle-button-background-active-dm", "#35505FFF"),//COLOR DEL FONDO DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO
            Map.entry("popup-toggle-button-border-active-dm", "#4DC0D4FF"),//COLOR DEL BORDE DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO
            Map.entry("popup-toggle-button-font-color-active-dm", "#4AB4C8FF"),//COLOR DE LA FUENTE DEL TOGGLE BUTTON EN POPUP CUANDO ESTÁ ACTIVO

            //SwitchButton
            Map.entry("switch-button-off-lm", "#CCCCCCFF"), //COLOR DEL FONDO DEL SWITCH BUTTON CUANDO NO ESTÁ ACTIVO
            Map.entry("switch-button-on-lm", "#192D91FF"), //COLOR DEL FONDO DEL SWITCH BUTTON CUANDO ESTÁ ACTIVO
            Map.entry("switch-button-thumb-lm", "#FFFFFFFF"), //COLOR DEL FONDO DEL THUMB DEL SWITCH BUTTON CUANDO NO ESTÁ ACTIVO

            Map.entry("switch-button-off-dm", "#394050FF"), //COLOR DEL FONDO DEL SWITCH BUTTON CUANDO NO ESTÁ ACTIVO
            Map.entry("switch-button-on-dm", "#4DC0D4FF"), //COLOR DEL FONDO DEL SWITCH BUTTON CUANDO ESTÁ ACTIVO
            Map.entry("switch-button-thumb-dm", "#2E3442FF"), //COLOR DEL FONDO DEL THUMB DEL SWITCH BUTTON CUANDO NO ESTÁ ACTIVO

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