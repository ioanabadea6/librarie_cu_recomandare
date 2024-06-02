import React, { Component } from "react";
import { Link } from "react-router-dom";
import "./Blog.css";

class Blog extends Component {
    render() {
        return (
            <div className="Blog">
                <div className="BlogHeader">
                    <h1>Book Heaven</h1>
                    <h2>
                        <Link to='/book' className="books">Books</Link>
                        {/*<Link to='/blog' className="blog">Blog</Link>*/}
                        {/*<Link to='/signup' className="signup">SignUp</Link>*/}
                        <Link to='/random-book' className="random-book">Random Book</Link>
                    </h2>
                </div>

                <div className="BlogBody">
                    <h3>Lansarea cartii "Calatorie in viitor"</h3>

                    <h5>Detalii eveniment</h5>
                    <h4>
                        Data: 13 iunie 2024<br/>
                        Ora: 18:00<br/>
                        Locatie: Libraria Centrala, Cluj Napoca<br/><br/>
                        Alatura-te noua pentru lansarea oficiala a cartii "Calatorie in viitor" de renumita autoare
                        Ioana Badea. Evenimentul va include o sesiune de autografe, o discutie cu autoarea despre
                        procesul de scriere si inspiratia din spatele cartii, precum si o prezentare speciala despre
                        temele explorate in roman. Participantii vor avea ocazia sa puna intrebari si sa discute direct
                        cu Ioana Badea, facand din acest eveniment o experienta de neuitat pentru toti iubitorii de
                        literatura.
                        <br/><br/>
                        Programul Evenimentului:<br/>
                        18:00 - 18:30: Primirea invitatilor si sesiune de networking<br/>
                        18:30 - 19:00: Prezentarea cartii de catre Ioana Badea<br/>
                        19:00 - 19:30: Sesiune de intrebari si raspunsuri<br/>
                        19:30 - 20:00: Sesiune de autografe si fotografii<br/><br/>
                        Intrarea: Libera
                    </h4>

                    <h4>
                        Intr-o lume in care granitele timpului sunt depasite, "Calatorie in viitor" ne poarta intr-o
                        aventura spectaculoasa prin viitorul omenirii. Protagonistul, un tanar cercetator pe nume
                        Adrian, descopera accidental un dispozitiv care ii permite sa calatoreasca in timp. Cu inima
                        plina de curiozitate si mintea setata pe explorare, Adrian se lanseaza intr-o calatorie care il
                        va duce dincolo de limitele imaginatiei.
                        <br/><br/>
                        Pe masura ce navigheaza prin diferite epoci viitoare, Adrian intalneste o serie de personaje
                        fascinante, de la inteligente artificiale avansate la comunitati umane care traiesc in simbioza
                        cu natura. Fiecare salt temporal dezvaluie noi provocari si mistere, punand la incercare
                        ingeniozitatea si curajul lui Adrian.
                        <br/><br/>
                        "Calatorie in viitor" exploreaza teme profunde precum impactul tehnologiei asupra societatii,
                        etica inovatiei stiintifice si natura umana in fata schimbarii. Cu o naratiune captivanta si
                        descrieri detaliate, Ioana Badea reuseste sa creeze un univers in care cititorii vor fi atrasi
                        intr-o cautare de sens si cunoastere.
                        <br/><br/>
                        Aceasta carte este un must-read pentru iubitorii de science fiction si pentru toti cei care se
                        intreaba cum ar putea arata viitorul nostru. Prin paginile ei, cititorii vor fi provocati sa
                        reflecteze asupra propriului lor prezent si sa viseze la posibilitatile nelimitate ale
                        viitorului.
                    </h4>

                    <h5>Detalii despre autor</h5>
                    <h4>
                        Ioana Badea este o autoare apreciata in literatura contemporana, cunoscuta pentru talentul sau
                        de a impleti elemente de science fiction cu teme filosofice si sociale. Nascuta si crescuta in
                        Bucuresti, Ioana si-a descoperit pasiunea pentru scris inca din copilarie, cand isi petrecea
                        timpul liber citind si inventand povesti fantastice.
                        <br/><br/>
                        Dupa ce a absolvit Facultatea de Litere, Ioana a lucrat ca jurnalista si editor, experiente care
                        i-au imbogatit stilul narativ si i-au oferit o perspectiva profunda asupra conditiei umane.
                        Prima ei carte, un roman de debut premiat, a fost rapid remarcata de critici si cititori
                        deopotriva pentru profunzimea emotionala si originalitatea sa.
                        <br/><br/>
                        In scrierile sale, Ioana exploreaza adesea teme precum identitatea, timpul si relatia omului cu
                        tehnologia. Personajele sale sunt bine conturate, iar lumile pe care le creeaza sunt atat de vii
                        incat par sa sara din pagini. Abilitatea ei de a descrie detalii complexe intr-un mod accesibil
                        si captivant a facut-o sa fie iubita de un public larg si divers.
                        <br/><br/>
                        Cand nu scrie, Ioana isi dedica timpul explorarii culturilor diferite, calatorind si participand
                        la conferinte si workshop-uri de scriere creativa. Ea considera ca fiecare experienta noua este
                        o sursa de inspiratie pentru urmatoarele ei povesti.
                        <br/><br/>
                        Prin cartile sale, Ioana Badea nu doar ca reuseste sa fascineze si sa provoace gandirea
                        cititorilor, dar ii si invita sa viseze la lumi noi si sa reflecteze asupra realitatii in care
                        traiesc.
                    </h4>

                </div>
            </div>
        )
    }
}

export default Blog;
