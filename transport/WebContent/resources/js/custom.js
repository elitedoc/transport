//javascript function which scroll to the first message in page   
function scrollToFirstMessage() {
     try {
        PrimeFaces.scrollTo($('.ui-message :first-child').eq(0).parent().attr('id'));
     } catch(err) {
       //No Message was found!
     }
  }

function hideMenu() {
	$("#leftColumn").hide(50);
	$("#hideBtn").hide();
	$("#showBtn").show();
}

function showMenu() {
	$("#leftColumn").show(50);
	$("#showBtn").hide();
	$("#hideBtn").show();
}


function TextLanguageAr(event) {
	//I will detect the Unicode of any key pressed
	//I query the which property In a keypress event because the Unicode
	//value of the key pressed is stored in either the keyCode or charCode property, never both. 
	var unicode = (event.keyCode ? event.keyCode : event.which);
	var res;
	switch (unicode) {
	case 222:
		res = 'ذ';
		break;
	case 65:
		res = 'ض';
		break;
	case 90:
		res = 'ص';
		break;
	case 69:
		res = 'ث';
		break;
	case 82:
		res = 'ق';
		break;
	case 84:
		res = 'ف';
		break;
	case 89:
		res = 'غ';
		break;
	case 85:
		res = 'ع';
		break;
	case 73:
		res = 'ه';
		break;
	case 79:
		res = 'خ';
		break;
	case 80:
		res = 'ح';
		break;
	case 221:
		res = 'ج';
		break;
	case 186:
		res = 'د';
		break;
	case 81:
		res = 'ش';
		break;
	case 83:
		res = 'س';
		break;
	case 68:
		res = 'ي';
		break;
	case 70:
		res = 'ب';
		break;
	case 71:
//		if (Shift_Key_pressed(e))
//			res = 'لأ';
//		else
			res = 'ل';
		break;
	case 72:
//		if (Shift_Key_pressed(e))
//			res = 'أ';
//		else
			res = 'ا';
		break;
	case 74:
		res = 'ت';
		break;
	case 75:
		res = 'ن';
		break;
	case 76:
		res = 'م';
		break;
	case 77:
		res = 'ك';
		break;
	case 192:
		res = 'ط';
		break;
	case 87:
		res = 'ئ';
		break;
	case 88:
		res = 'ء';
		break;
	case 67:
		res = 'ؤ';
		break;
	case 86:
		res = 'ر';
		break;
	case 66:
//		if (Shift_Key_pressed(e))
//			res = 'لآ';
//		else
			res = 'لا';
		break;
	case 78:
//		if (Shift_Key_pressed(e))
//			res = 'آ';
//		else
			res = 'ى';
		break;
	case 188:
		res = 'ة';
		break;
	case 190:
		res = 'و';
		break;
	case 191:
		res = 'ز';
		break;
	case 223:
		res = 'ظ';
		break;
	case 32:
		res = ' ';
		break;
	default:
		res ='';
		break;
	}
	return res;
}

function addArabicChar(event, elt) 
{
	elt.value = elt.value + TextLanguageAr(event);
}

function deleteLastChar(elt) 
{
	//alert(elt.value.substring(0, elt.value.length - 1));
	elt.value = elt.value.substring(0, elt.value.length - 1);
}

function blink(ob) 
{ 
if (ob.style.visibility == "visible" ) 
{ 
ob.style.visibility = "hidden"; 
} 
else 
{ 
ob.style.visibility = "visible"; 
} 
} 


$(document)
		.ready(
				function() {

					PrimeFaces.locales['fr'] = {
						closeText : 'Fermer',
						prevText : 'Précédent',
						nextText : 'Suivant',
						monthNames : [ 'Janvier', 'Février', 'Mars',
								'Avril', 'Mai', 'Juin', 'Juillet',
								'Août', 'Septembre', 'Octobre',
								'Novembre', 'Décembre' ],
						monthNamesShort : [ 'Jan', 'Fév', 'Mar', 'Avr',
								'Mai', 'Jun', 'Jul', 'Aoû', 'Sep',
								'Oct', 'Nov', 'Déc' ],
						dayNames : [ 'Dimanche', 'Lundi', 'Mardi',
								'Mercredi', 'Jeudi', 'Vendredi',
								'Samedi' ],
						dayNamesShort : [ 'Dim', 'Lun', 'Mar', 'Mer',
								'Jeu', 'Ven', 'Sam' ],
						dayNamesMin : [ 'Di', 'Lu', 'Ma', 'Me', 'Je',
								'Ve', 'Sa' ],
						weekHeader : 'Semaine',
						firstDay : 1,
						isRTL : false,
						showMonthAfterYear : false,
						yearSuffix : '',
						timeOnlyTitle : 'Choisir l\'heure',
						timeText : 'Heure',
						hourText : 'Heures',
						minuteText : 'Minutes',
						secondText : 'Secondes',
						currentText : 'Maintenant',
						ampm : false,
						month : 'Mois',
						week : 'Semaine',
						day : 'Jour',
						allDayText : 'Toute la journée'
					};
					$('.dateDeb').datepicker(
							{
								changeMonth : true,
								changeYear : true,
								dateFormat : "dd/mm/yy",
								dayNames : [ "Dimanche", "Lundi",
										"Mardi", "Mercredi", "Jeudi",
										"Vendredi", "Samedi" ],
								dayNamesMin : [ "Di", "Lu", "Ma", "Me",
										"Je", "Ve", "Sa" ],
								dayNamesShort : [ "Dim", "Lun", "Mar",
										"Mer", "Jeu", "Ven", "Sam" ],
								gotoCurrent : true,
								monthNames : [ "Janvier", "Février",
										"Mars", "Avril", "Mai", "Juin",
										"Juillet", "Août", "Septembre",
										"Octobre", "Novembre",
										"Decembre" ],
								monthNamesShort : [ "Jan", "Fev",
										"Mar", "Avr", "Mai", "Juin",
										"Juil", "Aoû", "Sep", "Oct",
										"Nov", "Dec" ],
								prevText : "Préc",
								nextText : "Suiv",
								yearRange : "-80y:+20y",
								onClose : function(selectedDate) {
									$(".dateFin").datepicker("option",
											"minDate", selectedDate);
								}
							});
					$('.dateFin').datepicker(
							{
								changeMonth : true,
								changeYear : true,
								dateFormat : "dd/mm/yy",
								dayNames : [ "Dimanche", "Lundi",
										"Mardi", "Mercredi", "Jeudi",
										"Vendredi", "Samedi" ],
								dayNamesMin : [ "Di", "Lu", "Ma", "Me",
										"Je", "Ve", "Sa" ],
								dayNamesShort : [ "Dim", "Lun", "Mar",
										"Mer", "Jeu", "Ven", "Sam" ],
								gotoCurrent : true,
								monthNames : [ "Janvier", "Février",
										"Mars", "Avril", "Mai", "Juin",
										"Juillet", "Août", "Septembre",
										"Octobre", "Novembre",
										"Decembre" ],
								monthNamesShort : [ "Jan", "Fev",
										"Mar", "Avr", "Mai", "Juin",
										"Juil", "Aoû", "Sep", "Oct",
										"Nov", "Dec" ],
								prevText : "Préc",
								nextText : "Suiv",
								yearRange : "-80y:+20y",
								onClose : function(selectedDate) {
									$(".dateDeb").datepicker("option",
											"maxDate", selectedDate);
								}
							});
//					for (i = 0; i < 1000; i++) 
//					{ 
//					    setInterval("blink(oId"+i+")",500); 
//					    setInterval("blink(uId"+i+")",500);
//					}
				});