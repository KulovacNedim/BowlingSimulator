<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <%@ include file="headTagContent.jsp"%>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <h1>Bowling Simulator 1.0</h1>
        <hr>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <h2>Set parameters:</h2>
        </div>
        <div class="col-sm-6">
          <form  class="form-horizontal" action="/simulate" method="post">
            <div class="form-group">
              <label for="skill">Select skill level:</label>
              <select class="form-control" id="skill" name="skill">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
              </select>
            </div>
            <div class="form-group">
              <label for="games">Number of games to simulate:</label>
              <input type="text" class="form-control" id="games" name="games">
            </div>
             <div class="form-group"> 
                <button type="submit" class="btn btn-default">Simulate</button>
            </div>
          </form>
        </div>
      </div>
      <hr>
      <div class="row">
        <c:forEach items="${simulatedGames}" var="game">
                    ${game.frames}
                    <br>
                                  <c:forEach items="${game.frames}" var="frame">
                                                      ${frame.toString()}
                                                      <br>
                                                      
                                                      <br>
                                                      ${game.scoreboard.toString()}
                                                  </c:forEach>                    <br>
                    ${game.scoreboard.toString()}
                </c:forEach>
      </div>
    </div>
 
  </body>
</html>
