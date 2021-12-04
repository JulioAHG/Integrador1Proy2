<footer>
    <div style='padding:0px;width:100%;text-align:center;'>
        Copyright © 2021 Electro Hogar | Todos los derechos reservados
    </div>
    
    <script>
        
        window.onscroll = function() {myFunction()};

        var header = document.getElementById("pestanas_menu");
        var sticky = header.offsetTop;

        function myFunction() {
        if (window.pageYOffset > sticky) {
            header.classList.add("menu_fixed");
        } else {
            header.classList.remove("menu_fixed");
        }
        }
    </script>
</footer>
