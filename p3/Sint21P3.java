package practica3;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import javax.net.ssl.ExtendedSSLSession;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Sint21P3 extends HttpServlet{
    private String password = "practica21";
    private PrintWriter aux;
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String fase = request.getParameter("fase");
        String errores = request.getParameter("errores");
        String auto = request.getParameter("auto");
        String password = request.getParameter("p");
        if(password!=null && password.equals(this.password)){
            if(movies==null){
                iniciarDatos(request);
                try{
                aux = new PrintWriter(new File("/home/adrian/log3.txt"));
                }catch(IOException e){

                }
            }
            if(errores!=null && errores.equals("si")){
                if(auto==null){
                    pantallaErrores(request, response);
                }
                else{
                    pantallaErroresAuto(request, response);
                }
            }
            else if(fase!=null){
                switch (fase) {
                    case "11":
                        if(auto==null)
                            pantallaFase11(request, response);
                        else
                            pantallaFase11Auto(request, response);
                        break;
                    case "12":
                        if(auto==null)
                            pantallaFase12(request, response);
                        else
                            pantallaFase12Auto(request, response);
                        break;
                    case "13":
                        if(auto==null)
                            pantallaFase13(request, response);
                        else
                            pantallaFase13Auto(request, response);
                        break;
                    case "14":
                        if(auto==null)
                            pantallaFase14(request, response);
                        else
                            pantallaFase14Auto(request, response);
                        break;
                    case "21":
                        pantallaFase21(request, response);
                        break;
                    case "22":
                        transformacionHTML(request, response);
                        break;
                    case "23":
                        transformacionRSS(request, response);
                        break;
                    default:
                        if(auto==null)
                            pantallaFase0(request, response);
                        else
                            pantallaFase0Auto(request, response);
                        break;
                }
            }
            else{
                if(auto==null)
                    pantallaFase0(request, response);
                else
                    pantallaFase0Auto(request, response);
                }
            }
        else if(password==null){
            if(auto!=null && auto.equals("si")){
                pantallasPasswdNoExistenteAuto(request, response);
            }
            else{
                pantallasPasswdNoExistente(request, response);
            }
        }
        else{
            if(auto!=null && auto.equals("si")){
                pantallasPasswdIncorrectaAuto(request, response);
            }
            else{
                pantallasPasswdIncorrecta(request, response);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        pantallaFase0(request, response);
    }


    /* **********************************************************   Funciones practica 3   ********************************************************* */

    public void pantallaFase21(HttpServletRequest request, HttpServletResponse response){
        try {
            Collections.sort(ficherosCorrectos);
            request.setAttribute("listaFicheros", ficherosCorrectos);
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase21.jsp");
            rd.forward(request, response);

        } catch (IOException io){
            io.printStackTrace(aux);
        }catch (ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void transformacionHTML(HttpServletRequest request, HttpServletResponse response){
        try{
            ServletContext context = getServletContext();
            String contextHTML = context.getRealPath("mml-html.xsl");
            response.setCharacterEncoding("UTF-8");
            URL urlFichero = new URL(request.getParameter("fichero"));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xsl = new StreamSource(new File(contextHTML));
            Templates template = tFactory.newTemplates(xsl);
            Transformer transformer = template.newTransformer();
            Source xml = new StreamSource(urlFichero.toExternalForm());
            transformer.transform(xml, new StreamResult(response.getWriter()));
        }catch(Exception e){
            try{
                e.printStackTrace(response.getWriter());
            }catch(IOException e2){

            }
        }
    }

    public void transformacionRSS(HttpServletRequest request, HttpServletResponse response){
        try{
            ServletContext context = getServletContext();
            String contextRSS = context.getRealPath("mml-rss.xsl");
            response.setCharacterEncoding("UTF-8");
            URL urlFichero = new URL(request.getParameter("fichero"));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xsl = new StreamSource(new File(contextRSS));
            Templates template = tFactory.newTemplates(xsl);
            Transformer transformer = template.newTransformer();
            Source xml = new StreamSource(urlFichero.toExternalForm());
            transformer.transform(xml, new StreamResult(response.getWriter()));
        }catch(Exception e){
             try{
                e.printStackTrace(response.getWriter());
            }catch(IOException e2){

            }
        }
    }

    /* **********************************************************   Funciones pantallas    ********************************************************* */

    public void pantallasPasswdNoExistente(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html; charset=ISO-8859-15");
            response.setCharacterEncoding("ISO-8859-15");
            PrintWriter pw = response.getWriter();

            pw.println("<!Doctype html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='Iso-8859-15'/>");
            pw.println("<link rel='stylesheet' type='text/css' href='mml.css'/>");
            pw.println("<title>Servicio de consulta de peliculas</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>No passwd</h1>");
            pw.println("<footer>");
            pw.println("<p>Diseñado por: Adrián Vázquez Saavedra</p>");
            pw.println("</footer>");
            pw.println("</body>");
            pw.println("</html>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallasPasswdNoExistenteAuto(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("application/xml");
            PrintWriter pw = response.getWriter();
            pw.println("<?xml version='1.0' encoding='utf-8'?>");
            pw.println("<wrongRequest>no passwd</wrongRequest>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallasPasswdIncorrecta(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html; charset=ISO-8859-15");
            response.setCharacterEncoding("ISO-8859-15");
            PrintWriter pw = response.getWriter();

            pw.println("<!Doctype html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='Iso-8859-15'/>");
            pw.println("<link rel='stylesheet' type='text/css' href='mml.css'/>");
            pw.println("<title>Servicio de consulta de peliculas</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>Bad passwd</h1>");
            pw.println("<footer>");
            pw.println("<p>Diseñado por: Adrián Vázquez Saavedra</p>");
            pw.println("</footer>");
            pw.println("</body>");
            pw.println("</html>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallasPasswdIncorrectaAuto(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("application/xml");
            PrintWriter pw = response.getWriter();
            pw.println("<?xml version='1.0' encoding='utf-8'?>");
            pw.println("<wrongRequest>bad passwd</wrongRequest>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallaErrores(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html; charset=ISO-8859-15");
            response.setCharacterEncoding("ISO-8859-15");
            PrintWriter pw = response.getWriter();

            pw.println("<!Doctype html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='Iso-8859-15'/>");
            pw.println("<link rel='stylesheet' type='text/css' href='mml.css'/>");
            pw.println("<title>Servicio de consulta de peliculas</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<div class='principal'>");
            pw.println("<form method='GET' action=''>");
            pw.println("<input type='hidden' name='fase'>");
            pw.println("<input type='hidden' name='p' value='"+request.getParameter("p")+"'>'");
            pw.println("<div>");
            pw.println("<h1>Servicio de consulta de peliculas</h1>");
            pw.println("<h3>Se han encontrado "+warnings.size()+" ficheros con warnings</h3>");
            pw.println("<ul>");
            for(int i=0; i<warnings.size(); i++){
                pw.println("<li>"+warnings.get(i).toString()+"</li>");
            }
            pw.println("</ul>");
            pw.println("<br>");
            pw.println("<h3>Se han encontrado "+errors.size()+" ficheros con errores</h3>");
            pw.println("<ul>");
            for(int i=0; i<errors.size(); i++){
                pw.println("<li>"+errors.get(i).toString()+"</li>");
            }
            pw.println("</ul>");
            pw.println("<br>");
            pw.println("<h3>Se han encontrado "+ferrors.size()+" ficheros con errores fatales</h3>");
            pw.println("<ul>");
            for(int i=0; i<ferrors.size(); i++){
                pw.println("<li>"+ferrors.get(i).toString()+"</li>");
            }
            pw.println("</ul>");
            pw.println("<br>");
            pw.println("<input type='submit' value='Atras' onclick='document.forms[0].fase.value=0'>");
            pw.println("</div>");
            pw.println("</form>");
            pw.println("<footer>");
            pw.println("<p>Diseñado por: Adrián Vázquez Saavedra</p>");
            pw.println("</footer>");
            pw.println("</div>");
            pw.println("</body>");
            pw.println("</html>");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallaErroresAuto(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("application/xml; charset=ISO-8859-15");
            response.setCharacterEncoding("ISO-8859-15");
            PrintWriter pw = response.getWriter();
            pw.println("<?xml version='1.0' encoding='utf-8'?>");
            pw.println("<errores>");
            pw.println("<warnings>");
            for(int i=0; i<warnings.size(); i++){
                pw.println("<warning>");
                pw.println("<file>"+warnings.get(i).getSystemId()+"</file>");
                pw.println("<cause>"+warnings.get(i).getMessage()+"</cause>");
                pw.println("</warning>");
            }
            pw.println("</warnings>");
            pw.println("<errors>");
            for(int i=0; i<errors.size(); i++){
                pw.println("<error>");
                pw.println("<file>"+errors.get(i).getSystemId()+"</file>");
                pw.println("<cause>"+errors.get(i).getMessage()+"</cause>");
                pw.println("</error>");
            }
            pw.println("</errors>");
            pw.println("<fatalerrors>");
            for(int i=0; i<ferrors.size(); i++){
                pw.println("<fatalerror>");
                pw.println("<file>"+ferrors.get(i).getSystemId()+"</file>");
                pw.println("<cause>"+ferrors.get(i).getMessage()+"</cause>");
                pw.println("</fatalerror>");
            }
            pw.println("</fatalerrors>");
            pw.println("</errores>");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void pantallaFase0(HttpServletRequest request, HttpServletResponse response){
         try {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase0.jsp");
            rd.forward(request, response);

        } catch (IOException io){
            io.printStackTrace(aux);
        }catch (ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase0Auto(HttpServletRequest request, HttpServletResponse response){
         try {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase0Auto.jsp");
            rd.forward(request, response);

        } catch (IOException io){
            io.printStackTrace(aux);
        }catch (ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase11(HttpServletRequest request, HttpServletResponse response){
         try {
            request.setAttribute("listaAnios", getC1Anios());
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase11.jsp");
            rd.forward(request, response);

        } catch (IOException io){
            io.printStackTrace(aux);
        }catch (ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase11Auto(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("listaAnios", getC1Anios());
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase11Auto.jsp");
            rd.forward(request, response);

        } catch (IOException io){
            io.printStackTrace(aux);
        }catch (ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase12(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setAttribute("listaPeliculas", getC1Peliculas(request.getParameter("anio")));
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase12.jsp");
            rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace(aux);
        }catch(ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase12Auto(HttpServletRequest request, HttpServletResponse response){
       try{
            request.setAttribute("listaPeliculas", getC1Peliculas(request.getParameter("anio")));
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase12Auto.jsp");
            rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace(aux);
        }catch(ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase13(HttpServletRequest request, HttpServletResponse response){
        try{
           request.setAttribute("listaActores", getC1Actores(request.getParameter("anio"), request.getParameter("pelicula")));
           ServletContext context = getServletContext();
           RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase13.jsp");
           rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ServletException e){
            e.printStackTrace();
        }
    }

    public void pantallaFase13Auto(HttpServletRequest request, HttpServletResponse response){
      try{
           request.setAttribute("listaActores", getC1Actores(request.getParameter("anio"), request.getParameter("pelicula")));
           ServletContext context = getServletContext();
           RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase13Auto.jsp");
           rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ServletException e){
            e.printStackTrace();
        }
    }

    public void pantallaFase14(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setAttribute("personaje", getC1Filmografía(request.getParameter("anio"), request.getParameter("pelicula"), request.getParameter("act")).getPersonaje());
            request.setAttribute("films", getC1Filmografía(request.getParameter("anio"), request.getParameter("pelicula"), request.getParameter("act")).getFilms());
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase14.jsp");
            rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace(aux);
        }catch(ServletException e){
            e.printStackTrace(aux);
        }
        aux.flush();
    }

    public void pantallaFase14Auto(HttpServletRequest request, HttpServletResponse response){
         try{
            request.setAttribute("personaje", getC1Filmografía(request.getParameter("anio"), request.getParameter("pelicula"), request.getParameter("act")).getPersonaje());
            request.setAttribute("listaFilms", getC1Filmografía(request.getParameter("anio"), request.getParameter("pelicula"), request.getParameter("act")).getFilms());
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/pantallaFase14Auto.jsp");
            rd.forward(request, response);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ServletException e){
            e.printStackTrace();
        }
    }


    /* ***************************************************** Manejo de datos ****************************************************** */


    public LinkedList<Anio> getC1Anios(){
        LinkedList<Anio> anios = new LinkedList<Anio>();
        Set<String> keys = movies.keySet();
        for(String key: keys){
            anios.add(movies.get(key));
        }
        Collections.sort(anios);
        return anios;
    }

    public LinkedList<Pelicula> getC1Peliculas(String anio){
        LinkedList<Pelicula> peliculas = new LinkedList<Pelicula>();
        Set<String> keys = movies.get(anio).getPeliculas().keySet();
        for(String key: keys){
            peliculas.add(movies.get(anio).getPeliculas().get(key));
        }
        Collections.sort(peliculas, new ComparadorTitulo());
        Collections.sort(peliculas);
        return peliculas;
    }

    public LinkedList<Actor> getC1Actores(String anio, String pelicula){
        LinkedList<Actor> actores = new LinkedList<Actor>();
        LinkedHashMap<String, Actor> actores2 = movies.get(anio).getPeliculas().get(pelicula).getReparto();
        Set<String> keys = actores2.keySet();
        for(String key: keys){
            actores.add(actores2.get(key));
        }
        Collections.sort(actores);
        return actores;
    }

    public Actor getC1Filmografía(String anio, String pelicula, String actor){
        Actor a = movies.get(anio).getPeliculas().get(pelicula).getReparto().get(actor);
        LinkedList<Film> films = new LinkedList<Film>();
        Set<String> keysAnios = movies.keySet();
        for(String keyAnios : keysAnios){
            LinkedHashMap<String, Pelicula> peliculas = movies.get(keyAnios).getPeliculas();
            Set<String> keysPeliculas = peliculas.keySet();
            for(String keyPeliculas : keysPeliculas){
                if(peliculas.get(keyPeliculas).getReparto().get(actor)!=null){
                    if(peliculas.get(keyPeliculas).getReparto().get(actor).getOscar()!=null){
                        Film f = new Film(keyPeliculas, peliculas.get(keyPeliculas).getReparto().get(actor).getOscar());
                        films.add(f);
                    }
                    else{
                        Film f = new Film(keyPeliculas);
                        films.add(f);
                    }
                }

            }
        }
        Collections.sort(films);
        a.setFilms(films);
        return a;
    }


    /******************************************************** Manejo de datos************************************************************* */
    private static final String mml2001 = "http://gssi.det.uvigo.es/users/agil/public_html/SINT/17-18/mml2001.xml";
    private static LinkedList<String> ficherosMML;
    private static LinkedList<String> ficherosCorrectos;
    private static LinkedHashMap<String, Anio> movies;
    private static LinkedList<SAXParseException> warnings;
    private static LinkedList<SAXParseException> errors;
    private static LinkedList<SAXParseException> ferrors;

    public void iniciarDatos(HttpServletRequest request){
        ficherosMML = new LinkedList<String>();
        ficherosCorrectos = new LinkedList<String>();
        ficherosMML.add(mml2001);
        movies = new LinkedHashMap<String, Anio>();
        warnings = new LinkedList<SAXParseException>();
        errors = new LinkedList<SAXParseException>();
        ferrors = new LinkedList<SAXParseException>();
        StringBuffer url;
        java.net.URL urlServlet;
        java.net.URL urlSchema = null;
        try{
            url = request.getRequestURL();
            urlServlet = new URL(url.toString());
            urlSchema = new URL(urlServlet, "mml.xsd");
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
       for(int i=0; i<ficherosMML.size(); i++){
           try{
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = sFactory.newSchema(urlSchema);
                documentBuilderFactory.setSchema(schema);
                DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
                dBuilder.setErrorHandler(new XML_ErrorHandler());
                Document document;
                if(ficherosMML.get(i).split(":")[0].equals("http")){
                    document = dBuilder.parse(ficherosMML.get(i));
                }
                else{
                    document = dBuilder.parse("http://gssi.det.uvigo.es/users/agil/public_html/SINT/17-18/"+ficherosMML.get(i));
                }
                anadirMML(document);
           }catch(SAXParseException e){
                e.printStackTrace();
           }catch(SAXException e){
                e.printStackTrace();
           }catch(IOException e){
                e.printStackTrace();
           }catch(ParserConfigurationException e){
                e.printStackTrace();
           }catch(XPathExpressionException e){
                e.printStackTrace();
           }
       }

    }


    public void anadirMML(Document document) throws XPathExpressionException{
          XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression exprt = xPath.compile("/Movies/Anio/text()");
        NodeList nl = (NodeList)exprt.evaluate(document, XPathConstants.NODESET);
        Anio anio = new Anio(nl.item(0).getNodeValue());

        exprt = xPath.compile("/Movies/Pais/@pais");
        nl = (NodeList)exprt.evaluate(document, XPathConstants.NODESET);
        for(int i=0; i<nl.getLength(); i++){
            String pais = nl.item(i).getNodeValue();
            exprt = xPath.compile("(/Movies/Pais[@pais='"+pais+"']/@lang)");
            String lang = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
            exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula/@ip");
            NodeList nl2 = (NodeList)exprt.evaluate(document, XPathConstants.NODESET);
            Pelicula[] peliculas = new Pelicula[nl2.getLength()];
            for(int j=0; j<nl2.getLength(); j++){
                String ip = nl2.item(j).getNodeValue();
                exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/@langs");
                String langs = lang;
                if(((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).getLength()>0)
                  langs = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();

                exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Titulo/text()");
                String titulo = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Duracion/text()");
                String duracion = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Generos/Genero/text()");
                String[] generos = new String[((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).getLength()];
                for(int a=0; a<generos.length; a++){
                    generos[a] = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(a).getNodeValue();
                }
                Pelicula p = new Pelicula(pais, lang, langs, ip, titulo, generos, duracion);

                exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto/Nombre/text()");
                NodeList nl3 = (NodeList)exprt.evaluate(document, XPathConstants.NODESET);
                for(int k=0; k<nl3.getLength(); k++){
                    String nombre = nl3.item(k).getNodeValue();
                    exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/Personaje/text()");
                    String personaje = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                    exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/Oscar/text()");
                    String oscar = null;
                    if(((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).getLength()!=0)
                        oscar = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                    exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/OtraPelicula/MML/text()");
                    NodeList nl4 = (NodeList)exprt.evaluate(document, XPathConstants.NODESET);
                    String[] otraPelicula = new String[nl4.getLength()];
                    String[] otroMML = new String[nl4.getLength()];
                    for(int z=0; z<nl4.getLength(); z++) {
                        exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/OtraPelicula/ip/text()");
                        if(((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).getLength()!=0){
                            otraPelicula[z] = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                        }
                        else{
                            exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/OtraPelicula/Titulo/text()");
                            otraPelicula[z] = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue();
                        }
                        exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']/OtraPelicula/MML/text()");
                        otroMML[z] = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getNodeValue().trim();
                        boolean estaDefinido = false;
                        for(int q=0; q<ficherosMML.size(); q++){
                            if(otroMML[z].equals(ficherosMML.get(q)))
                                estaDefinido = true;
			    else if(ficherosMML.get(q).equals("http://gssi.det.uvigo.es/users/agil/public_html/SINT/17-18/"+otroMML[z].trim())){
		              	estaDefinido = true;
                            }
                        }
                        if(!estaDefinido)
                            ficherosMML.add(otroMML[z]);
                    }
                    exprt = xPath.compile("/Movies/Pais[@pais='"+pais+"']/Pelicula[@ip='"+ip+"']/Reparto[Nombre='"+nombre+"']");
                    NodeList todo = ((NodeList)exprt.evaluate(document, XPathConstants.NODESET)).item(0).getChildNodes();
                    String direccion = null;
                    boolean esDireccion = true;
                    for(int t=0; t<todo.getLength(); t++){
                        esDireccion = true;
                        if(t>=todo.getLength())
                            break;
                        direccion = todo.item(t).getTextContent().trim();
                        if(todo.item(t).getNodeName().equals("OtraPelicula"))
			    continue;
			if(direccion.equals(""))
                            continue;
                        if(direccion.equals(nombre.trim()))
                            continue;
                        if(direccion.equals(personaje.trim()))
                            continue;
                        if(oscar!=null && direccion.equals(oscar.trim()))
                            continue;
                        for(int z=0; z<otraPelicula.length; z++){
                            if(direccion.equals(otraPelicula[z].trim()))
                                esDireccion = false;
                            if(direccion.equals(otroMML[z].trim()))
                                esDireccion = false;
                        }
                        if(esDireccion)
                            break;
                    }
                    Actor a = new Actor(nombre, personaje, oscar, direccion, otraPelicula, otroMML);
                    p.addActor(a);
                }
                anio.addPelicula(p);
            }
        }
        movies.put(anio.getAnio(), anio);
        ficherosCorrectos.add(document.getBaseURI());
    }

    public static class XML_ErrorHandler extends DefaultHandler{
        public void warning(SAXParseException spe) throws SAXException{
            warnings.add(spe);
            throw new SAXException();
        }

        public void error(SAXParseException spe) throws SAXException{
            errors.add(spe);
            throw new SAXException();
        }

        public void fatalError(SAXParseException spe) throws SAXException{
            ferrors.add(spe);
            throw new SAXException();
        }

    }

}
