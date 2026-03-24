// 博客交互功能
document.addEventListener('DOMContentLoaded', function() {
    // 为所有"阅读更多"链接添加点击事件
    const readMoreLinks = document.querySelectorAll('.read-more');
    
    readMoreLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            alert('文章详情功能正在开发中...');
        });
    });
    
    // 导航链接点击效果
    const navLinks = document.querySelectorAll('nav a');
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            alert('导航功能正在开发中...');
        });
    });
});