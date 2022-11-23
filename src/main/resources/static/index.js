let fromFile = document.getElementById('inputfile');

fromFile.addEventListener('change', function() {

            var fr=new FileReader();

            fr.onload=function(){
                document.getElementById("text").value=fr.result;
            }

            fr.readAsText(this.files[0]);

        })

            let cyrillicLatinMap = new Map();
            cyrillicLatinMap.set("й", "q");
            cyrillicLatinMap.set('ц', 'w');
            cyrillicLatinMap.set('у', 'e');
            cyrillicLatinMap.set('е', 't');
            cyrillicLatinMap.set('н', 'y');
            cyrillicLatinMap.set('к', 'r');
            cyrillicLatinMap.set('г', 'u');
            cyrillicLatinMap.set('ш', 'i');
            cyrillicLatinMap.set('щ', 'o');
            cyrillicLatinMap.set('з', 'p');
            cyrillicLatinMap.set('ф', 'a');
            cyrillicLatinMap.set('і', 's');
            cyrillicLatinMap.set('в', 'd');
            cyrillicLatinMap.set('а', 'f');
            cyrillicLatinMap.set('п', 'g');
            cyrillicLatinMap.set('р', 'h');
            cyrillicLatinMap.set('о', 'j');
            cyrillicLatinMap.set('л', 'k');
            cyrillicLatinMap.set('д', 'l');
            cyrillicLatinMap.set('я', 'z');
            cyrillicLatinMap.set('ч', 'x');
            cyrillicLatinMap.set('с', 'c');
            cyrillicLatinMap.set('м', 'v');
            cyrillicLatinMap.set('и', 'b');
            cyrillicLatinMap.set('т', 'n');
            cyrillicLatinMap.set('ь', 'm');
//            cyrillicLatinMap.set('ю', '.');
                        cyrillicLatinMap.set("Й", "Q");
                        cyrillicLatinMap.set('Ц', 'W');
                        cyrillicLatinMap.set('У', 'E');
                        cyrillicLatinMap.set('Е', 'T');
                        cyrillicLatinMap.set('Н', 'Y');
                        cyrillicLatinMap.set('К', 'R');
                        cyrillicLatinMap.set('Г', 'U');
                        cyrillicLatinMap.set('Ш', 'I');
                        cyrillicLatinMap.set('Щ', 'O');
                        cyrillicLatinMap.set('З', 'P');
                        cyrillicLatinMap.set('Ф', 'A');
                        cyrillicLatinMap.set('І', 'S');
                        cyrillicLatinMap.set('В', 'D');
                        cyrillicLatinMap.set('А', 'F');
                        cyrillicLatinMap.set('П', 'G');
                        cyrillicLatinMap.set('Р', 'H');
                        cyrillicLatinMap.set('О', 'J');
                        cyrillicLatinMap.set('Л', 'K');
                        cyrillicLatinMap.set('Д', 'L');
                        cyrillicLatinMap.set('Я', 'Z');
                        cyrillicLatinMap.set('Ч', 'X');
                        cyrillicLatinMap.set('С', 'C');
                        cyrillicLatinMap.set('М', 'V');
                        cyrillicLatinMap.set('И', 'B');
                        cyrillicLatinMap.set('Т', 'N');
                        cyrillicLatinMap.set('Ь', 'M');
                        cyrillicLatinMap.set('Ю', '>');

            cyrillicLatinMap.set('х', '[');
            cyrillicLatinMap.set('ї', ']');
            cyrillicLatinMap.set('ж', ';');
            cyrillicLatinMap.set('є', '\\');
            cyrillicLatinMap.set('б', ',',);
                        cyrillicLatinMap.set('Х', '{');
                        cyrillicLatinMap.set('Ї', '}');
                        cyrillicLatinMap.set('Ж', ':');
                        cyrillicLatinMap.set('Є', '"');
                        cyrillicLatinMap.set('Б', '<');
//            cyrillicLatinMap.set('ю', '.');

            cyrillicLatinMap.set('"', '"');
            //cyrillicLatinMap.set('.', '/');



        function setCharAt(str,index,chr) {
            if(index > str.length-1) return str;
            return str.substring(0,index) + chr + str.substring(index+1);
        }

        function sleep(ms) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }

        function ajaxPostCall(){
            let text = document.getElementById("text");
            if (text.value.length == 0){
                return;
            }
            postData = text.value;
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/changeToLatin",
                data: JSON.stringify(postData),
                dataType: "text",
                failure: function(msg){
                    alert("Failure" + msg);
                }
            });

            return true;
        }


        function makeVisible(){
            if (document.getElementById("text").value == ""){
                alert("No data entered");
            }
            document.getElementById("sentenceCountLabel").style.display = 'block';
            document.getElementById("table-id").style.display = 'block';
        }



<!--        function importData() {-->
<!--            let input = document.createElement('input');-->
<!--            input.type = 'file';-->
<!--            input.accept=".txt";-->

<!--            input.onchange = e => {-->
<!--                let file = e.target.files[0];-->
<!--                console.log("got to onchange");-->
<!--                let reader = new FileReader();-->
<!--                reader.readAsText(file, 'UTF-8');-->

<!--                reader.onload = readerEvent =>{-->
<!--                    document.getElementById("text").value = readerEvent.target.result;-->
<!--                    console.log("got to onload");-->
<!--                }-->
<!--            }-->

<!--            input.click();-->
<!--        }-->



        var openFile = function() {
            let input = document.createElement('input');
            input.type = 'file';
            input.accept=".txt";

<!--            var reader = new FileReader();-->
<!--            reader.onload = function() {-->
<!--                document.getElementById('text').value = reader.result;-->
<!--            };-->

<!--            reader.readAsText(input.files[0]);-->
        };

        function changeToLatin(){
                let input = document.getElementById("text").value;
                for (let i=0; i<input.length; i++){
                    if (cyrillicLatinMap.has(input[i])){
                        input = setCharAt(input , i, cyrillicLatinMap.get(input[i]));
                    }
                }
                document.getElementById("text").value = input;
        }

        function getByValue(map, searchValue) {
          for (let [key, value] of map.entries()) {
            if (value === searchValue)
              return key;
          }
          return null;
        }

        function changeToCyrillic(){
                  let input = document.getElementById("text").value;
                  for (let i=0; i<input.length; i++){
                       if (getByValue(cyrillicLatinMap, input[i]) != null){
                            input = setCharAt(input , i, getByValue(cyrillicLatinMap, input[i]));
                       }
                  }
                  document.getElementById("text").value = input;
        }

        function getLanguage(){
                              let input = document.getElementById("text").value;
                              let latin = 0;
                              let cyrillic = 0;
                              for (let i=0; i<input.length; i++){
                                   if (cyrillicLatinMap.has(input[i])){
                                        cyrillic = 1;
                                   }
                                   else if(getByValue(cyrillicLatinMap, input[i]) != null){
                                        latin = 1;
                                   }

                              }

                              let language = "";
                              if (latin == 1 && cyrillic  == 1){
                                language = "Custom"
                              }
                              else if (latin == 1){
                              language = "Latin"
                              }
                              else if (cyrillic == 1){
                              language = "Cyrillic"
                              }


                              document.getElementById("language-id").innerText = language;
        }


