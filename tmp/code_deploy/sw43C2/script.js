// 博客交互功能
document.addEventListener('DOMContentLoaded', function() {
    // 文章点击效果
    const articles = document.querySelectorAll('article');
    
    articles.forEach(article => {
        article.addEventListener('click', function() {
            this.style.backgroundColor = '#f0f0f0';
            setTimeout(() => {
                this.style.backgroundColor = '#f9f9f9';
            }, 300);
        });
    });
    
    // 导航菜单交互
    const navLinks = document.querySelectorAll('nav a');
    
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            alert('导航到: ' + this.textContent);
        });
    });
});