color 1F
mode con cols=80 lines=35
pushd "%~dp0" 
java -jar dist\Zork.jar
@echo off
color 1F
echo.
echo.
set /p input=Do you want to party with me? [y/n]:
if %input%==y goto A
if %input%==n goto B
if %input%==n goto B

:A
:top
cls
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo               *********                       
echo               ***    ***                                          
echo               ***    ***                      ******               
echo               *********               ******    **                 
echo               ***           ***       **   *    **   **    **      
echo               ***          ** **      ******    **    **  **       
echo               ***         *******     ** **     **      **     
echo               ***        **     **    **  **    **      **         
echo               ***       **       **   **   **   **      **         
echo.
color 1a
ping localhost -n 0 >nul
color 2b
ping localhost -n 0 >nul
color 3c
ping localhost -n 0 >nul
color 4d
ping localhost -n 0 >nul
color 5e
ping localhost -n 0 >nul
color 6f
ping localhost -n 0 >nul
color 7a
ping localhost -n 0 >nul
color 8b
ping localhost -n 0 >nul
color 9c
ping localhost -n 0 >nul
goto time


:B
echo.
title Goodbye
color 0c
cls
echo ---------------
echo You are uncool!	
echo ---------------
ping localhost -n 3 >nul
echo -----------------------
echo        Goodbye!	
echo -----------------------
ping localhost -n 4 >nul
exit

:time
cls
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo                *********                              *****
echo                *********                              *****    
echo                   ***     **                ******     ***
echo                   ***     **                **         ***
echo                   ***                       **          *
echo                   ***     **   *********    ****        *
echo                   ***     **   **  **  **   **
echo                   ***     **   **  **  **   **         ***
echo                   ***     **   **  **  **   ******     ***
echo.
echo.
color 1a
ping localhost -n 0 >nul
color 2b
ping localhost -n 0 >nul
color 3c
ping localhost -n 0 >nul
color 4d
ping localhost -n 0 >nul
color 5e
ping localhost -n 0 >nul
color 6f
ping localhost -n 0 >nul
color 7a
ping localhost -n 0 >nul
color 8b
ping localhost -n 0 >nul
color 9c
ping localhost -n 0 >nul
goto top

cmd /k

