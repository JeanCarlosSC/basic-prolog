/*
	Presentado por:
		Jean Carlos Santoya Cabrera - 20191020156

	Nota:
		ejecutar al menos el codigo del punto 1 o el codigo del punto 2 pero no
		los dos de forma simultanea. es decir nunca se comenta el codigo 
		antiWarnings y las reglas generales.
*/

%- - - - - -codigo antiWarnings - - - - - - -%

:- discontiguous escudero/1.
:- discontiguous caballero/1.

%- - - - - - - reglas generales - - - - - - -%

condicional(X, Y) :- (X -> (Y -> true; false); true).
bicondicional(X, Y) :- condicional(X, Y), condicional(Y, X).

esCaballero(X) :- not(escudero(X)); caballero(X).
esEscudero(X) :- not(caballero(X)); escudero(X).
naturaleza(X) :- (esCaballero(X)-> true; false).
/*
%- - - - - - - - - punto 1 - - - - - - - - -%

escudero(a).%hecho variable 1
escudero(b).%hecho variable 2

palabraDeA() :- esEscudero(a), not(esEscudero(b)).%hecho

%valida si las condiciones variables son válidas
esValido() :- bicondicional(naturaleza(a), palabraDeA()).

% el punto 1 solo es valido cuando a es escudero y b es escudero.
*/
%- - - - - - - - - punto 2 - - - - - - - - -%

escudero(a).%hecho variable 1
caballero(b).%hecho variable 2
escudero(c).%hecho variable 3

palabraDeA() :- esEscudero(a), esEscudero(b), esEscudero(c).%hecho 1
palabraDeB() :- (esCaballero(a), esEscudero(b), esEscudero(c));
				(esEscudero(a), esCaballero(b), esEscudero(c));
				(esEscudero(a), esEscudero(b), esCaballero(c)).%hecho 2

%valida si las condiciones variables son válidas
esValido() :- bicondicional(naturaleza(a), palabraDeA()),
			  bicondicional(naturaleza(b), palabraDeB()).

% el punto 2 solo es valido cuando escudero(a), caballero(b) y escudero(c).