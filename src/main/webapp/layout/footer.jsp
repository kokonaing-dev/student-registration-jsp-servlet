
<!-- Main content section ends here -->
</div>
</div>
<!-- Footer section -->
<div id="testfooter">
	<span>Copyright &#169; ACE Inspiration 2023</span>
</div>
<!-- JavaScript for dropdown functionality -->
<script>
        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }
    </script>
</body>
</html>
