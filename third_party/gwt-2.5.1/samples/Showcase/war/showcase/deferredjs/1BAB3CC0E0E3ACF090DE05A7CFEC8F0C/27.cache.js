function cwb(a){this.b=a}
function _vb(a,b){this.b=a;this.c=b}
function hT(a,b){var c;c=BT((wT(),b));return iT(a,c,b,false)}
function Xvb(a){var b,c,d;b=Bqc(ur(a.b.db,TIc));c=Bqc(ur(a.c.db,TIc));d=Bqc(ur(a.d.db,TIc));x2b(a.g,YLc+b+ZLc+c+$Lc+d+PEc);C2b(a.e,YLc+hT(a.f,b)+ZLc+pgb(c)+$Lc+hT(a.f,d)+PEc)}
function Wvb(a){var b,c,d,e,f,g;d=new h5b;b=AU(d.k,99);d.p[cHc]=5;g=Ygb(f2);e=new UZb(g);vj(e,new _vb(a,g),(ux(),ux(),tx));f=new Z6b;f.f[cHc]=3;W6b(f,new G2b("Cet exemple interagit avec l'interface \uFFFDchantillon:"));W6b(f,e);b5b(d,0,0,f);q5b(b,0)[SIc]=2;$4b(d,1,0,'<b>Mod\uFFFDle de message:<\/b>');$4b(d,1,1,"Utilisateur {0} ({1}  postes) a ajout\xE9 un commentaire sur '{2}'");a.b=new Gac;wac(a.b,(tF(),'\u05EA\u05D5\u05DE\u05E8 \u05D2\u05E8\u05D9\u05DF'));$4b(d,2,0,'<b>Argument {0}:<\/b>');b5b(d,2,1,a.b);a.c=new Gac;wac(a.c,'16');$4b(d,3,0,'<b>Argument {1}:<\/b>');b5b(d,3,1,a.c);a.d=new Gac;wac(a.d,'\u05DB\u05DE\u05D4 \u05D7\u05D5\u05DC \u05D9\u05E9 \u05D1\u05D7\u05D5\u05E3?');$4b(d,4,0,'<b>Argument {2}:<\/b>');b5b(d,4,1,a.d);a.g=new E2b;$4b(d,5,0,'<b>Message mis en forme sans BidiFormatter:<\/b>');b5b(d,5,1,a.g);v5b(b,5,0,(t6b(),s6b));a.e=new E2b;$4b(d,6,0,'<b>Message mis en forme avec BidiFormatter:<\/b>');b5b(d,6,1,a.e);v5b(b,6,0,s6b);c=new cwb(a);vj(a.b,c,(ey(),ey(),dy));vj(a.c,c,dy);vj(a.d,c,dy);Xvb(a);return d}
var $Lc="  postes) a ajout\xE9 un commentaire sur '",YLc='Utilisateur ';Meb(646,1,WAc,_vb);_.Hc=function awb(a){Rgb(this.b,this.c+_Lc)};_.b=null;_.c=null;Meb(647,1,HAc,cwb);_.Jc=function dwb(a){Xvb(this.b)};_.b=null;Meb(648,1,ZAc);_.qc=function hwb(){phb(this.c,Wvb(this.b))};var f2=ppc(_Hc,'BlogMessages'),i2=npc(_Hc,'CwBidiFormatting$1',646),j2=npc(_Hc,'CwBidiFormatting$2',647);MBc(In)(27);